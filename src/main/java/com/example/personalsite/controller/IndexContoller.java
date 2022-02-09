package com.example.personalsite.controller;

import com.example.personalsite.model.Article;
import com.example.personalsite.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexContoller {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/api/article")
    public @ResponseBody Article[] ResponseArticle() {
        Article[] article = articleService.selectAll();

        return article;
    }

}
