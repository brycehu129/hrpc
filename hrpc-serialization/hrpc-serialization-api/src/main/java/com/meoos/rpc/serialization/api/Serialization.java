package com.meoos.rpc.serialization.api;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 序列化接口
 */
public interface Serialization {

    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T obj);

    /**
     * 反序列化
     * @param data
     * @param cls
     * @param <T>
     * @return
     */
    <T> T deserialize(byte[] data,Class<T> cls);

}
