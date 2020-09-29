package com.ormissia.blog.service;

import com.ormissia.blog.pojo.User;

import java.util.HashMap;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/24 15:04
 */
public interface LoginService {

    public HashMap<String,String> userLogin(String username, String password);
}
