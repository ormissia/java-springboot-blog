package com.ormissia.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 宋奕锟
 * @Date: Create in 2020/9/24 14:52
 *
 * 用户登录接口
 */

@Controller
@RequestMapping("/api/private")
public class LoginController {

    @ResponseBody
    @RequestMapping("/login")
    public String login(){
        return "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 500,\n" +
                "        \"rid\": 0,\n" +
                "        \"username\": \"admin\",\n" +
                "        \"mobile\": \"123\",\n" +
                "        \"email\": \"123@qq.com\",\n" +
                "        \"token\": \"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjUwMCwicmlkIjowLCJpYXQiOjE1MTI1NDQyOTksImV4cCI6MTUxMjYzMDY5OX0.eGrsrvwHm-tPsO9r_pxHIQ5i5L1kX9RX444uwnRGaIM\"\n" +
                "    },\n" +
                "    \"meta\": {\n" +
                "        \"msg\": \"登录成功\",\n" +
                "        \"status\": 200\n" +
                "    }\n" +
                "}";
    }
}
