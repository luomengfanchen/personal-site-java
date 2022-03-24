package com.example.personalsite.utils;

import java.text.SimpleDateFormat;

import com.example.personalsite.model.Article;
import com.example.personalsite.model.ResponseArticle;

public class ConverArticle {
    /**
     * 转换数据封装
     * @param article
     * @return
     */
    public static ResponseArticle Conver(Article article) {
        ResponseArticle resp = new ResponseArticle();

        resp.setAuthor(article.getAuthor());
        resp.setCategory(article.getCategory());
        resp.setContent(article.getContent());
        resp.setId(article.getId());
        resp.setReading(article.getReading());
        resp.setReleasedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getReleasedate()));
        resp.setTitle(article.getTitle());

        return resp;
    }

    /**
     * 转换数据封装
     * @param articles
     * @return
     */
    public static ResponseArticle[] Conver(Article[] articles) {
        ResponseArticle[] resp = new ResponseArticle[articles.length];

        for (int i = 0; i < articles.length; i++) {
            ResponseArticle tmp = new ResponseArticle();

            tmp.setAuthor(articles[i].getAuthor());
            tmp.setCategory(articles[i].getCategory());
            tmp.setContent(articles[i].getContent());
            tmp.setId(articles[i].getId());
            tmp.setReading(articles[i].getReading());
            tmp.setReleasedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(articles[i].getReleasedate()));
            tmp.setTitle(articles[i].getTitle());

            resp[i] = tmp;
        }

        return resp;
    }
}
