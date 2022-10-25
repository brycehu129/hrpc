package com.meoos.rpc.provider;

import com.meoos.rpc.common.scanner.server.RpcServiceScanner;
import com.meoos.rpc.provider.common.server.base.BaseServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 以Java原生方式启动启动Rpc
 */
public class RpcSingleServer extends BaseServer {

    private final Logger logger = LoggerFactory.getLogger(RpcSingleServer.class);

    public RpcSingleServer(String serverAddress, String scanPackage, String reflectType) {
        super(serverAddress, reflectType);
        try {
            this.handlerMap = RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService(scanPackage);
        }catch (Exception e){
            logger.error("RPC Server init error",e);
        }
    }
}
