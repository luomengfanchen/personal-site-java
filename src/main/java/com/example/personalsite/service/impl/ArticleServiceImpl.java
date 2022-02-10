package com.example.personalsite.service.impl;

import com.example.personalsite.mapper.ArticleMapper;
import com.example.personalsite.model.Article;
import com.example.personalsite.service.ArticleService;
import com.example.personalsite.utils.ArticleResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleResponse Article() {
        Article[] data = articleMapper.selectAll();

        return ArticleResponse.responseOK(data);
    }
    
}
