package com.meoos.rpc.scanner.reference;

import com.meoos.rpc.scanner.ClassScanner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description @RpcReference注解扫描器
 */
public class RpcReferenceScanner extends ClassScanner {

    /**
     * 扫描指定包下的类，并筛选使用@RpcService注解标注的类
     * @param scanPackage
     * @return
     */
    public static Map<String, Object> doScannerWithRpcReferenceAnnotationFilter(/*String host, int port, */ String scanPackage/*, RegistryService registryService*/){
        Map<String, Object> handlerMap = new HashMap<>();


        return handlerMap;
    }

}
