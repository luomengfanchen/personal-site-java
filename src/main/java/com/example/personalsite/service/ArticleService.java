package com.example.personalsite.service;

import com.example.personalsite.mapper.ArticleMapper;
import com.example.personalsite.model.Article;
import com.example.personalsite.service.ArticleService;
import com.example.personalsite.utils.ConverArticle;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 返回所有文章
     * @return
     */
    public Response Article() {
        Article[] data = articleMapper.selectAll();

        return Response.responseOK(ConverArticle.Conver(data));
    }

    /**
     * 返回指定id的文章
     * @param id
     * @return
     */
    public Response Article(int id) {
        Article data = articleMapper.selectByPrimaryKey(id);

        return Response.responseOK(ConverArticle.Conver(data));
    }

    /**
     * 搜索文章
     * @param searchValue
     * @return
     */
    public Response Article(String searchValue) {
        Article[] data = articleMapper.selectByTitle(searchValue);

        return Response.responseOK(ConverArticle.Conver(data));
    }

    /**
     * 返回指定分类的文章
     * @param category
     * @return
     */
    public Response ArticleOfCategory(String category) {
        Article[] data = articleMapper.selectByCategory(category);

        return Response.responseOK(ConverArticle.Conver(data));
    }
}
