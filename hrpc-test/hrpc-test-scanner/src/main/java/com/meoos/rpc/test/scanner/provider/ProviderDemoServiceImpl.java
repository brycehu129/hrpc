package com.meoos.rpc.test.scanner.provider;

import com.meoos.rpc.annotation.RpcService;
import com.meoos.rpc.test.scanner.service.DemoService;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description DemoService实现类
 */
@RpcService(interfaceClass = DemoService.class,interfaceClassName = "com.meoos.rpc.test.scanner.service.DemoService",version = "1.0.0",group = "meoos")
public class ProviderDemoServiceImpl implements DemoService {

}
