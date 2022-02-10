package com.example.personalsite.controller;

import com.example.personalsite.service.ArticleService;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/api/article")
    public @ResponseBody Response Article() {
        return articleService.Article();
    }
}
