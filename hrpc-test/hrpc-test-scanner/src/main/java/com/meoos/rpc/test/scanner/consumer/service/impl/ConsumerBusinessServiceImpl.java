package com.meoos.rpc.test.scanner.consumer.service.impl;

import com.meoos.rpc.annotation.RpcReference;
import com.meoos.rpc.test.scanner.consumer.service.ConsumerBusinessService;
import com.meoos.rpc.test.scanner.service.DemoService;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 服务消费者业务逻辑实现类
 */
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {

    @RpcReference(registryType = "zookeeper",registryAddress = "127.0.0.1:2181",version = "1.0.0",group = "meoos")
    private DemoService demoService;

}
