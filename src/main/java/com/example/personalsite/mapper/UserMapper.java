package com.example.personalsite.mapper;

import com.example.personalsite.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByuserName(String username);

    User selectByEmailAndPassword(String email, String password);

    User selectByToken(String token);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}