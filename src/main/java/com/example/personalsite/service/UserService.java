package com.example.personalsite.service;

import com.example.personalsite.model.User;
import com.example.personalsite.utils.Response;

public interface UserService {
    Response Register(User user);

    Response Login(User user);
}
