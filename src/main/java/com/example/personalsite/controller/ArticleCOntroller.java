package com.example.personalsite.controller;

import com.example.personalsite.service.ArticleService;
import com.example.personalsite.utils.ArticleResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleCOntroller {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/api/article")
    public @ResponseBody ArticleResponse Article() {
        return articleService.Article();
    }
}
