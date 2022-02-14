package com.example.personalsite.config;

import com.example.personalsite.interceptor.UserAuthInterceptor;
import com.example.personalsite.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] excludePathPatterns = {
            "/api/article",
            "/api/register",
            "/api/login"
        };

        registry.addInterceptor(new UserAuthInterceptor(userMapper))
        .addPathPatterns("/api/user/**")
        .excludePathPatterns(excludePathPatterns);
    }
}
