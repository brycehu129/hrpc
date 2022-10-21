package com.meoos.rpc.serialization.jdk;


import com.meoos.rpc.serialization.api.Serialization;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description Jdk Serialization
 */
public class JdkSerialization implements Serialization {
    @Override
    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> cls) {
        return null;
    }
}
