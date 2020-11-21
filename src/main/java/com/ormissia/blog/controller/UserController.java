package com.ormissia.blog.controller;

import com.ormissia.blog.pojo.ReturnResult;
import com.ormissia.blog.pojo.User;
import com.ormissia.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public ReturnResult<User> login(HttpServletRequest request, @RequestBody HashMap<String, Object> requestBody) {
        ReturnResult<User> result = new ReturnResult<>();

        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");
        //获取登录返回值
        User user = userService.selectUserByUsername(username);
        if (user == null) {
            //用户不存在
            result.setCode(ReturnResult.STATUS_LOGIN_USER_NOT_FOUND_VALUE);
            result.setMessage("用户不存在");
        } else if (!user.getPassword().equals(password)) {
            //密码错误
            result.setCode(ReturnResult.STATUS_LOGIN_PASSWORD_ERROR_VALUE);
            result.setMessage("密码不对欸，再想想？");
        } else {
            //登录成功
            result.setCode(ReturnResult.STATUS_RESPONSE_SUCCESSFUL_VALUE);
            result.setMessage("登录成功");

            //将用户信息添加到向前端的返回值中
            user.setPassword(null);

            //添加到session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            result.setData(user);
        }

        return result;
    }
}
