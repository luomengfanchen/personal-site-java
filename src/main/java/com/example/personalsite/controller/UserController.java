package com.example.personalsite.controller;

import com.example.personalsite.model.User;
import com.example.personalsite.service.UserService;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/api/register")
    public @ResponseBody Response UserRegister(@RequestBody User param) {

        return userService.Register(param);
    }

    @PostMapping(value = "/api/login")
    public @ResponseBody Response UserLogin(@RequestBody User param) {

        return userService.Login(param);
    }
}
