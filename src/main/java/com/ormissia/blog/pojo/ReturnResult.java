package com.ormissia.blog.pojo;

import java.io.Serializable;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/27 16:03
 *
 * 统一返回值对象
 */
public class ReturnResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    //返回值状态码
    public static final Integer STATUS_RESPONSE_SUCCESSFUL_VALUE = 200;
    public static final Integer STATUS_INTERNAL_RESPONSE_SERVER_ERROR_VALUE = 500;

    public static final Integer STATUS_LOGIN_PASSWORD_ERROR_VALUE = 201;//登录密码错误
    public static final Integer STATUS_LOGIN_USER_NOT_FOUND_VALUE = 405;//登录用户不存在


    private Integer code;//异常状态码
    private String message;//提示信息
    private T data;//返回数据

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code +
                "\",\"message\":\"" + message + '\'' +
                "\",\"data\":\"" + data +
                "\"}";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
