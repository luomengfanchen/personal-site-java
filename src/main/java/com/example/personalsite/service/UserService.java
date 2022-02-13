package com.example.personalsite.service;

import java.util.Date;

import com.example.personalsite.mapper.ArticleMapper;
import com.example.personalsite.mapper.UserMapper;
import com.example.personalsite.model.Article;
import com.example.personalsite.model.User;
import com.example.personalsite.service.UserService;
import com.example.personalsite.utils.ConverArticle;
import com.example.personalsite.utils.Encoding;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

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


    public Response Login(User user) {

        // 加密密码
        user.setPassword(Encoding.Md5(user.getPassword()));

        // 验证用户密码是否正确
        User authUser = userMapper.selectByEmailAndPassword(user.getEmail(), user.getPassword());
        if (authUser == null) {
            return Response.responseError();
        }

        return Response.responseOK(authUser.getToken());
    }


    public Response UserInfoGet(String token) {
        User userInfo = userMapper.selectByToken(token);

        User respUser = new User();
        respUser.setEmail(userInfo.getEmail());
        respUser.setName(userInfo.getName());

        return Response.responseOK(respUser);
    }

    public Response NewArticle(String token, Article article) {

        User userInfo = userMapper.selectByToken(token);

        article.setAuthor(userInfo.getName());
        article.setReleasedate(new Date());
        article.setReading(0L);

        int result = articleMapper.insertSelective(article);

        System.out.println(result);

        return Response.responseOK();
    }

    public Response GetArticle(String token) {
        User userInfo = userMapper.selectByToken(token);

        Article[] article = articleMapper.selectByAuthor(userInfo.getName());

        return Response.responseOK(ConverArticle.Conver(article));
    }

    public Response ModifyArticle(String token, Integer id, Article param) {

        User userInfo = userMapper.selectByToken(token);

        param.setId(id);
        param.setAuthor(userInfo.getName());
        param.setReleasedate(new Date());

        articleMapper.updateByPrimaryKey(param);

        return Response.responseOK();
    }
}
