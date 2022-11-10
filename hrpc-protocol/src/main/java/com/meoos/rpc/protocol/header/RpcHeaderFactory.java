package com.meoos.rpc.protocol.header;

import com.meoos.rpc.common.id.IdFactory;
import com.meoos.rpc.constants.RpcConstants;
import com.meoos.rpc.protocol.enumeration.RpcType;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description RpcHeaderFactory
 */
public class RpcHeaderFactory {

    public static RpcHeader getRequestHeader(String serializationType) {
        RpcHeader header = new RpcHeader();
        long requestId = IdFactory.getId();
        header.setMagic(RpcConstants.MAGIC);
        header.setRequestId(requestId);
        header.setMsgType((byte) RpcType.REQUEST.getType());
        header.setStatus((byte) 0x1);
        header.setSerializationType(serializationType);
        return header;
    }

}
