package com.example.personalsite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.personalsite.mapper.UserMapper;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthInterceptor implements HandlerInterceptor {

    private UserMapper userMapper;

    public UserAuthInterceptor(UserMapper userMapper) {
        super();
        this.userMapper = userMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if(token == null || userMapper.selectByToken(token) == null) {

            response.sendError(401, "Unauthorized");

            return false;
        }

        return true;
    }
}
