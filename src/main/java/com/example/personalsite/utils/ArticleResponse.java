package com.example.personalsite.utils;

import com.example.personalsite.model.Article;

public class ArticleResponse {
    private String msg;
    private Article[] data;

    public String getMsg() {
        return this.msg;
    }

    public Article[] getData() {
        return this.data;
    }

    public static ArticleResponse responseOK(Article[] data) {
        ArticleResponse resp = new ArticleResponse();

        resp.msg = "successful";
        resp.data = data;

        return resp;
    }

    public static ArticleResponse responseOK() {
        ArticleResponse resp = new ArticleResponse();

        resp.msg = "error";

        return resp;
    }
}
