package com.example.personalsite.service.impl;

import com.example.personalsite.mapper.ArticleMapper;
import com.example.personalsite.model.Article;
import com.example.personalsite.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article[] selectAll() {
        return articleMapper.selectAll();
    }
    
}
