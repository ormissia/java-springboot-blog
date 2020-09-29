package com.ormissia.blog.pojo;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/28 16:32
 */
public class ReturnStatus {

    public static final String STATUS_RESPONSE_CODE_KEY = "status";
    public static final String STATUS_RESPONSE_MESSAGE_KEY = "message";


    public static final Integer STATUS_RESPONSE_SUCCESSFUL_VALUE = 200;
    public static final Integer STATUS_INTERNAL_RESPONSE_SERVER_ERROR_VALUE = 500;

    public static final Integer STATUS_LOGIN_PASSWORD_ERROR_VALUE = 201;//登录密码错误
    public static final Integer STATUS_LOGIN_USER_NOT_FOUND_VALUE = 405;//登录用户不存在

}
