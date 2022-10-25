package com.meoos.rpc.common.utils;

import java.util.stream.IntStream;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 序列化时针对消息头序列化类型的操作
 */
public class SerializationUtils {

    private static final String PADDING_String = "0";

    /**
     * 约定序列化类型最大长度为16
     */
    public static final int MAX_SERIALIZATION_TYPE_COUNT = 16;

    /**
     * 为长度不足16的字符串后面补0
     * @param str 原始字符串
     * @return 补0后的字符串
     */
    public static String paddingString(String str){
        str = transNullToEmpty(str);
        if (str.length()>MAX_SERIALIZATION_TYPE_COUNT){
            return str;
        }
        int paddingCount = MAX_SERIALIZATION_TYPE_COUNT - str.length();
        StringBuilder paddingString = new StringBuilder(str);
        IntStream.range(0,paddingCount).forEach((i)->{
            paddingString.append(PADDING_String);
        });
        return paddingString.toString();
    }

    public static String subString(String str){
        str = transNullToEmpty(str);
        return str.replace(PADDING_String,"");
    }

    private static String transNullToEmpty(String str) {
        return str == null ? "":str;
    }

}
