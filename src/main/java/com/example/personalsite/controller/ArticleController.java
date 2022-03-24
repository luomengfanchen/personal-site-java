package com.example.personalsite.controller;

import com.example.personalsite.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 返回文章接口
     * 无参数返回最新文章
     * 通过category参数查询文章分类
     * 通过search参数查询文章
     * 通过id参数查询指定文章
     * @return
     */
    @GetMapping(value = "/api/article")
    public ResponseEntity<Object> Article(@RequestParam(required = false) String id,
                                        @RequestParam(required = false) String search,
                                        @RequestParam(required = false) String category) {

        if (id != null) {
            return articleService.Article(Integer.parseInt(id));
        }

        if (search != null) {
            return articleService.Article(search);
        }

        if (category != null) {
            return articleService.ArticleOfCategory(category);
        }

        return articleService.Article();
    }
}
