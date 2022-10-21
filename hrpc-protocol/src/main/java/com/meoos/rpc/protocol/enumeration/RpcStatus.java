package com.meoos.rpc.protocol.enumeration;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description RPC服务状态
 */
public enum RpcStatus {

    SUCCESS(0),
    FAIL(1)
    ;

    private final int code;

    RpcStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
