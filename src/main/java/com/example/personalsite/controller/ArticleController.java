package com.example.personalsite.controller;

import com.example.personalsite.service.ArticleService;
import com.example.personalsite.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody Response Article(@RequestParam(required = false) String id,
                                        @RequestParam(required = false) String search) {

        if (id != null) {
            return articleService.Article(Integer.parseInt(id));
        }

        if (search != null) {
            return articleService.Article(search);
        }

        return articleService.Article();
    }
}
