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

    public Response Article() {
        Article[] data = articleMapper.selectAll();

        return Response.responseOK(ConverArticle.Conver(data));
    }

    public Response Article(int id) {
        Article data = articleMapper.selectByPrimaryKey(id);

        return Response.responseOK(ConverArticle.Conver(data));
    }

    public Response Article(String searchValue) {
        Article[] data = articleMapper.selectByTitle(searchValue);

        return Response.responseOK(ConverArticle.Conver(data));
    }

    public Response ArticleOfCategory(String category) {
        Article[] data = articleMapper.selectByCategory(category);

        return Response.responseOK(ConverArticle.Conver(data));
    }
}
