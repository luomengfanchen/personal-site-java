package com.example.personalsite.service.impl;

import com.example.personalsite.mapper.UserMapper;
import com.example.personalsite.model.User;
import com.example.personalsite.service.UserService;
import com.example.personalsite.utils.Encoding;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public Response Register(User user) {

        // 查询用户是否已注册
        if (userMapper.selectByuserName(user.getName()) != null) {
            return Response.responseError();
        }

        // 加密密码
        user.setPassword(Encoding.Md5(user.getPassword()));

        // 生成token
        user.setToken(Encoding.Md5(user.getEmail() + user.getPassword()));

        // 将数据插入到数据库中
        userMapper.insertSelective(user);

        return Response.responseOK();
    }
}
