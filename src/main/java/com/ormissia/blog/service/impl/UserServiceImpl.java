package com.ormissia.blog.service.impl;

import com.ormissia.blog.dao.UserDao;
import com.ormissia.blog.pojo.User;
import com.ormissia.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/24 15:04
 */

@Service("LoginService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    /*
    * 判断用户是否登录成功
    * 状态码-loginFlag：0-密码错误，1-登录成功，2-用户不存在
    * */
    public HashMap<String,String> userLogin(String username, String password) {
        //返回值，默认为 0
        HashMap<String,String> resultMap = new HashMap<>();

        //判断用户是否存在
        User user = userDao.selectUserByUsername(username);
        if (user == null){
            //用户不存在
            resultMap.put("loginFlag","2");
            return resultMap;
        }
        if (user.getPassword().equals(password)) {
            //密码正确，登陆成功
            resultMap.put("loginFlag","1");
            resultMap.put("userId",user.getUserId());
            resultMap.put("userRoleId",user.getUserRoleId());
            resultMap.put("username",user.getUsername());
            resultMap.put("email",user.getEmail());
            resultMap.put("phoneNumber",user.getPhoneNumber());
            resultMap.put("headPortrait",user.getHeadPortrait());
        }else {
            //密码错误
            resultMap.put("loginFlag","0");
        }

        return resultMap;
    }
}
