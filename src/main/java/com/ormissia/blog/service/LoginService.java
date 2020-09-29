package com.ormissia.blog.service;

import java.util.HashMap;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/24 15:04
 */
public interface LoginService {

    HashMap<String,String> userLogin(String username, String password);
}
