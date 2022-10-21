package com.meoos.rpc.provider.common.handler;

import com.meoos.rpc.common.threadpool.ServerThreadPool;
import com.meoos.rpc.protocol.Response.RpcResponse;
import com.meoos.rpc.protocol.RpcProtocol;
import com.meoos.rpc.protocol.enumeration.RpcStatus;
import com.meoos.rpc.protocol.enumeration.RpcType;
import com.meoos.rpc.protocol.header.RpcHeader;
import com.meoos.rpc.protocol.request.RpcRequest;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description
 */
public class RpcProviderHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcRequest>> {

    private final Logger logger = LoggerFactory.getLogger(RpcProviderHandler.class);
    //存储服务名称#版本号#分组与对象实例的映射关系
    private final Map<String,Object> handlerMap;
    //调用采用哪种类型调用真实方法
    private final String reflectType;

    public RpcProviderHandler(String reflectType,Map<String,Object> handlerMap){
        this.handlerMap = handlerMap;
        this.reflectType = reflectType;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcRequest> protocol) throws Exception {
        ServerThreadPool.submit(()->{
            RpcHeader header = protocol.getHeader();
            header.setMsgType((byte) RpcType.RESPONSE.getType());
            RpcRequest request = protocol.getBody();
            logger.debug("Receive request " + header.getRequestId());
            RpcProtocol<RpcResponse> responseRpcProtocol = new RpcProtocol<>();
            RpcResponse response = new RpcResponse();
            try {
                Object result =handle(request);
                response.setResult(result);
                response.setAsync(request.getAsync());
                response.setOneway(request.getOneway());
                header.setStatus((byte) RpcStatus.SUCCESS.getCode());
            }catch (Throwable t){
                response.setError(t.toString());
                header.setStatus((byte) RpcStatus.FAIL.getCode());
                logger.error("RPC Server handle request error",t);
            }
            responseRpcProtocol.setHeader(header);
            responseRpcProtocol.setBody(response);
            ctx.writeAndFlush(responseRpcProtocol).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    logger.debug("Send response for request " + header.getRequestId());
                }
            });
        });
    }

    private Object handle(RpcRequest request) {
        return null;
    }
}
