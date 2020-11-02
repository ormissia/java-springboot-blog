package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.ReturnResult;
import com.ormissia.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/24 14:52
 * <p>
 * 用户登录接口
 */

@RestController
@RequestMapping("/api")
@Api(tags = "用户控制器")
public class UserController {

    @Resource
    private UserService userService;

    //用户登录
    @RequestMapping(value = "/public/login", method = RequestMethod.POST)
    @ApiOperation("登录的接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "requestBody", value = "用户名", required = true, dataType = "HashMap")
//    })
    public ReturnResult<LinkedHashMap<String, Object>> login(@RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<LinkedHashMap<String, Object>> result = new ReturnResult<>();

        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");
        //获取登录返回值
        HashMap<String, String> isSuccessful = userService.userLogin(username, password);//判断是否登录成功

        //生成返回JSON
        //判断loginFlag状态码：0-密码错误，1-登录成功，2-用户不存在
        String loginFlag = isSuccessful.get("loginFlag");
        if ("0".equals(loginFlag)) {
            //密码错误
            result.setCode(ReturnResult.STATUS_LOGIN_PASSWORD_ERROR_VALUE);
            result.setMessage("密码不对欸，再想想？");
        } else if ("1".equals(loginFlag)) {
            //登录成功
            result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
            result.setMessage("登录成功");

            //将用户信息添加到向前端的返回值中
            LinkedHashMap<String, Object> data = new LinkedHashMap<>();
            data.put("userId", isSuccessful.get("userId"));
            data.put("userRoleId", isSuccessful.get("userRoleId"));
            data.put("username", isSuccessful.get("username"));
            data.put("email", isSuccessful.get("email"));
            data.put("phoneNumber", isSuccessful.get("phoneNumber"));
            data.put("headPortrait", isSuccessful.get("headPortrait"));

            //添加token
            data.put("token", "123123123");

            result.setData(data);
        } else {
            //用户不存在
            result.setCode(ReturnResult.STATUS_LOGIN_USER_NOT_FOUND_VALUE);
            result.setMessage("用户不存在");
        }

        return result;
    }
}
