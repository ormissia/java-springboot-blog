package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.ReturnStatus;
import com.ormissia.blog.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/24 14:52
 * <p>
 * 用户登录接口
 */

@RestController
@RequestMapping("/api/private")
@Api(tags = "用户控制器")
public class LoginController {

    @Resource
    private LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    public LinkedHashMap<String,Object> login(String username,String password) {
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();

        //获取登录返回值
        HashMap<String,String> isSuccessful = loginService.userLogin(username, password);//判断是否登录成功

        //生成返回JSON
        //判断loginFlag状态码：0-密码错误，1-登录成功，2-用户不存在
        String loginFlag = isSuccessful.get("loginFlag");
        if ("0".equals(loginFlag)){
            //密码错误
            result.put(ReturnStatus.STATUS_RESPONSE_CODE_KEY,ReturnStatus.STATUS_LOGIN_PASSWORD_ERROR_VALUE);
            result.put(ReturnStatus.STATUS_RESPONSE_MESSAGE_KEY,"密码错误");
        }else if ("1".equals(loginFlag)){
            //登录成功
            result.put(ReturnStatus.STATUS_RESPONSE_CODE_KEY,ReturnStatus.STATUS_RESPONSE_SUCCESSFUL_VALUE);
            result.put(ReturnStatus.STATUS_RESPONSE_MESSAGE_KEY,"登录成功");

            //将用户信息添加到向前端的返回值中
            LinkedHashMap<String,String> data = new LinkedHashMap<>();
            data.put("token","123123123");

            result.put("data",data);

        }else {
            //用户不存在
            result.put(ReturnStatus.STATUS_RESPONSE_CODE_KEY,ReturnStatus.STATUS_LOGIN_USER_NOT_FOUND_VALUE);
            result.put(ReturnStatus.STATUS_RESPONSE_MESSAGE_KEY,"用户不存在");
        }

        return result;
    }
}
