package com.meoos.rpc.protocol.header;

import java.io.Serializable;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 消息头，目前固定为32个字节
 */
public class RpcHeader implements Serializable {

    private static final long serialVersionUID = 4523217279842372022L;

    /*
    +---------------------------------------------------------------+
    | 魔数 2byte | 报文类型 1byte | 状态 1byte |     消息 ID 8byte      |
    +---------------------------------------------------------------+
    |           序列化类型 16byte      |        数据长度 4byte          |
    +---------------------------------------------------------------+
    */

    /**
     * 魔数 2字节
     */
    private short magic;

    /**
     * 报文类型 1字节
     */
    private byte msgType;

    /**
     * 状态 1字节
     */
    private byte status;

    /**
     * 消息 ID 8字节
     */
    private Long requestId;

    /**
     * 序列化类型16字节，不足16字节后面补0，约定序列化类型长度最多不能超过16
     */
    private String serializationType;

    /**
     * 消息长度 4字节
     */
    private int magLen;

    public short getMagic() {
        return magic;
    }

    public void setMagic(short magic) {
        this.magic = magic;
    }

    public byte getMsgType() {
        return msgType;
    }

    public void setMsgType(byte msgType) {
        this.msgType = msgType;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getSerializationType() {
        return serializationType;
    }

    public void setSerializationType(String serializationType) {
        this.serializationType = serializationType;
    }

    public int getMagLen() {
        return magLen;
    }

    public void setMagLen(int magLen) {
        this.magLen = magLen;
    }
}
