package com.meoos.rpc.test.provider.single;

import com.meoos.rpc.provider.RpcSingleServer;
import org.junit.Test;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 测试Java原生启动RPC
 */
public class RpcSingleServerTest {

    @Test
    public void startRpcSingleServer(){
        RpcSingleServer singleServer = new RpcSingleServer("127.0.0.1:27880","com.meoos.rpc.test","cglib");
        singleServer.startNettyServer();
    }

}
