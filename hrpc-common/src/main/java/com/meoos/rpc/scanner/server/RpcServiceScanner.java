package com.meoos.rpc.scanner.server;

import com.meoos.rpc.annotation.RpcService;
import com.meoos.rpc.scanner.ClassScanner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description @RpcService注解扫描器
 */
public class RpcServiceScanner extends ClassScanner {


    public static Map<String, Object> doScannerWithRpcServiceAnnotationFilterAndRegistryService(String scanPackage){
        Map<String, Object> handlerMap = new HashMap<>();


        return handlerMap;
    }

    /**
     * 获取serviceName
     * @param rpcService
     * @return
     */
    private static String getServiceName(RpcService rpcService){
        //优先使用interfaceClass
        Class clazz = rpcService.interfaceClass();
        if (clazz == void.class){
            return rpcService.interfaceClassName();
        }
        String serviceName = clazz.getName();
        if (serviceName == null || serviceName.trim().isEmpty()){
            serviceName = rpcService.interfaceClassName();
        }
        return serviceName;
    }

}
