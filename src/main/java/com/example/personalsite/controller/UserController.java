package com.example.personalsite.controller;

import com.example.personalsite.model.Article;
import com.example.personalsite.model.User;
import com.example.personalsite.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

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
    public ResponseEntity<Object> UserRegister(@RequestBody User param) {

        return userService.Register(param);
    }

    /**
     * 处理登录请求
     * @param param json请求体
     * @return
     */
    @PostMapping(value = "/api/login")
    public ResponseEntity<Object> UserLogin(@RequestBody User param) {

        return userService.Login(param);
    }

    /**
     * 响应用户信息
     * @param token
     * @return
     */
    @GetMapping(value = "/api/user/user")
    public ResponseEntity<Object> UserGet(@RequestHeader("Authorization") String token) {

        return userService.UserInfoGet(token);
    }

    /**
     * 获取用户自己的文章
     * @return
     */
    @GetMapping(value = "/api/user/article")
    public ResponseEntity<Object> GetArticle(@RequestHeader("Authorization") String token) {
        return userService.GetArticle(token);
    }

    /**
     * 用户新建自己的文章
     * @param token
     * @param param
     * @return
     */
    @PostMapping(value = "/api/user/article")
    public ResponseEntity<Object> NewArticle(@RequestHeader("Authorization") String token,
                                        @RequestBody Article param) {

        return userService.NewArticle(token, param);
    }

    /**
     * 修改用户自己的文章
     * @param token
     * @param param
     * @return
     */
    @PatchMapping(value = "/api/user/article/{id}")
    public ResponseEntity<Object> ModifyArticle(@RequestHeader("Authorization") String token,
                                        @PathVariable Integer id,
                                        @RequestBody Article param) {

        return userService.ModifyArticle(token, id, param);
    }

    /**
     * 删除用户自己的文章
     * @param token
     * @param id
     * @param param
     * @return
     */
    @DeleteMapping(value = "/api/user/article/{id}")
        public ResponseEntity<Object> DeleteyArticle(@RequestHeader("Authorization") String token,
                                        @PathVariable Integer id) {

        return userService.DeleteArticle(token, id);
    }
}
