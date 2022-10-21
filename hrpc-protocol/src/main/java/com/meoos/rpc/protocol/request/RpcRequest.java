package com.meoos.rpc.protocol.request;

import com.meoos.rpc.protocol.base.RpcMessage;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description Rpc请求封装类，对应的请求id在消息头中
 */
public class RpcRequest extends RpcMessage {

    private static final long serialVersionUID = -8874882930916377802L;
    /**
     * 类名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数类型数组
     */
    private Object[] parameters;

    /**
     * 版本号
     */
    private String version;

    /**
     * 服务分组
     */
    private String group;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
