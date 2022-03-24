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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 处理用户注册请求
     * @param user
     * @return 注册是否成功
     */
    public ResponseEntity<Object> Register(User user) {

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


    /**
     * 处理用户登录请求
     * @param user
     * @return 用户token
     */
    public ResponseEntity<Object> Login(User user) {

        // 加密密码
        user.setPassword(Encoding.Md5(user.getPassword()));

        // 验证用户密码是否正确
        User authUser = userMapper.selectByEmailAndPassword(user.getEmail(), user.getPassword());
        if (authUser == null) {
            return Response.responseError();
        }

        return Response.responseOK(authUser.getToken());
    }


    /**
     * 返回用户信息
     * @param token
     * @return
     */
    public ResponseEntity<Object> UserInfoGet(String token) {
        User userInfo = userMapper.selectByToken(token);

        User respUser = new User();
        respUser.setEmail(userInfo.getEmail());
        respUser.setName(userInfo.getName());

        return Response.responseOK(respUser);
    }

    /**
     * 新建文章
     * @param token
     * @param article
     * @return
     */
    public ResponseEntity<Object> NewArticle(String token, Article article) {

        User userInfo = userMapper.selectByToken(token);

        article.setAuthor(userInfo.getName());
        article.setReleasedate(new Date());
        article.setReading(0L);

        articleMapper.insertSelective(article);

        return Response.responseOK();
    }

    /**
     * 返回用户自己的文章
     * @param token
     * @return
     */
    public ResponseEntity<Object> GetArticle(String token) {
        User userInfo = userMapper.selectByToken(token);

        Article[] article = articleMapper.selectByAuthor(userInfo.getName());

        return Response.responseOK(ConverArticle.Conver(article));
    }

    /**
     * 修改文章
     * @param token
     * @param id
     * @param param
     * @return
     */
    public ResponseEntity<Object> ModifyArticle(String token, Integer id, Article param) {

        User userInfo = userMapper.selectByToken(token);

        param.setId(id);
        param.setAuthor(userInfo.getName());
        param.setReleasedate(new Date());
        param.setReading(0L);

        articleMapper.updateByPrimaryKeyWithBLOBs(param);

        return Response.responseOK();
    }

    /**
     * 删除文章
     * @param token
     * @param id
     * @return
     */
    public ResponseEntity<Object> DeleteArticle(String token, Integer id) {

        User userInfo = userMapper.selectByToken(token);

        if (userInfo == null) {
            return Response.responseError();
        }

        articleMapper.deleteByPrimaryKey(id);

        return Response.responseOK();
    }
}
