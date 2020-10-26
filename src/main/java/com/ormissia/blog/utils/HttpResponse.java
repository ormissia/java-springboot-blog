package com.ormissia.blog.utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/10/26 11:40
 */
public class HttpResponse extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    //状态码
    public static final String CODE_TAG = "code";
    //返回内容
    public static final String MSG_TAG = "msg";
    //数据对象
    public static final String DATA_TAG = "data";

    //状态类型
    public enum Type {
        //成功
        SUCCESS(0),
        //警告
        WARN(301),
        //错误
        ERROR(500);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    //初始化一个只空的HttpRequest对象
    public HttpResponse() {
    }

    //初始化一个只有状态码和返回消息的HttpRequest对象
    public HttpResponse(Type type, String message) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, message);
    }

    //初始化一个完整的HttpRequest对象
    public HttpResponse(Type type, String message, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, message);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }
}
