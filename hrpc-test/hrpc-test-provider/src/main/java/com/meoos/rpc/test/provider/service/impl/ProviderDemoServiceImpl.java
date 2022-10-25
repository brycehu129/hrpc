package com.meoos.rpc.test.provider.service.impl;

import com.meoos.rpc.annotation.RpcService;
import com.meoos.rpc.test.api.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description DemoService实现类
 */
@RpcService(interfaceClass = DemoService.class,interfaceClassName = "com.meoos.rpc.test.api.DemoService",version = "1.0.0",group = "binghe")
public class ProviderDemoServiceImpl implements DemoService{

    private static final Logger logger = LoggerFactory.getLogger(ProviderDemoServiceImpl.class);

    @Override
    public String hello(String name) {
        logger.info("调用hello方法传入的参数为===>>>{}", name);
        return "hello " + name;
    }
}
