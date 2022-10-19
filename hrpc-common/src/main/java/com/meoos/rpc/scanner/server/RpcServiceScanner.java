package com.meoos.rpc.scanner.server;

import com.meoos.rpc.annotation.RpcService;
import com.meoos.rpc.scanner.ClassScanner;
import com.meoos.rpc.scanner.helper.RpcServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description @RpcService注解扫描器
 */
public class RpcServiceScanner extends ClassScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServiceScanner.class);

    /**
     * 扫描指定包下的类，并筛选使用@RpcService注解标注的类
     *
     * @param scanPackage
     * @return
     * @throws IOException
     */
    public static Map<String, Object> doScannerWithRpcServiceAnnotationFilterAndRegistryService(String scanPackage) throws IOException {
        Map<String, Object> handlerMap = new HashMap<>();
        List<String> classNameList = getClassNameList(scanPackage);
        if (classNameList == null || classNameList.isEmpty()) {
            return handlerMap;
        }
        classNameList.stream().forEach(className->{
            try {
                Class<?> clazz = Class.forName(className);
                RpcService rpcService = clazz.getAnnotation(RpcService.class);
                if (rpcService!=null){
                    //优先使用interfaceClass, interfaceClass的name为空，再使用interfaceClassName
                    //TODO 后续逻辑向注册中心注册服务元数据，同时向handlerMap中记录标注了RpcService注解的类实例
                    //handlerMap中的Key先简单存储为serviceName+version+group，后续根据实际情况处理key
                    String serviceName = getServiceName(rpcService);
                    String key = RpcServiceHelper.buildServiceKey(serviceName,rpcService.version(),rpcService.group());
                    handlerMap.put(key,clazz.newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return handlerMap;
    }

    /**
     * 获取serviceName
     *
     * @param rpcService
     * @return
     */
    private static String getServiceName(RpcService rpcService) {
        //优先使用interfaceClass
        Class clazz = rpcService.interfaceClass();
        if (clazz == void.class) {
            return rpcService.interfaceClassName();
        }
        String serviceName = clazz.getName();
        if (serviceName == null || serviceName.trim().isEmpty()) {
            serviceName = rpcService.interfaceClassName();
        }
        return serviceName;
    }

}
