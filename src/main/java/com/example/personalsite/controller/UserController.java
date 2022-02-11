package com.example.personalsite.controller;

import com.example.personalsite.model.User;
import com.example.personalsite.service.UserService;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 处理注册请求
     * @param param json请求体
     * @return
     */
    @PostMapping(value = "/api/register")
    public @ResponseBody Response UserRegister(@RequestBody User param) {

        return userService.Register(param);
    }

    /**
     * 处理登录请求
     * @param param json请求体
     * @return
     */
    @PostMapping(value = "/api/login")
    public @ResponseBody Response UserLogin(@RequestBody User param) {

        return userService.Login(param);
    }

    /**
     * 响应用户信息
     * @param token
     * @return
     */
    @GetMapping(value = "/api/user/user")
    public @ResponseBody Response UserGet(@RequestHeader("Authorization") String token) {

        return userService.UserInfoGet(token);
    }
}
