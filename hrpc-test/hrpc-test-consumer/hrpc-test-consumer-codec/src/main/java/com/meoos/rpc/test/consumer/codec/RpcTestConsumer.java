package com.meoos.rpc.test.consumer.codec;

import com.meoos.rpc.test.consumer.codec.init.RpcTestConsumerInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 测试消费端
 */
public class RpcTestConsumer {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(4);
        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new RpcTestConsumerInitializer());
            bootstrap.connect("127.0.0.1",27880).sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(2000);
            eventLoopGroup.shutdownGracefully();
        }
    }

}
