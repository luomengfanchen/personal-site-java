package com.example.personalsite.mapper;

import com.example.personalsite.model.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    Article[] selectAll();

    Article[] selectByTitle(String title);

    Article[] selectByCategory(String category);

    Article[] selectByAuthor(String author);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}