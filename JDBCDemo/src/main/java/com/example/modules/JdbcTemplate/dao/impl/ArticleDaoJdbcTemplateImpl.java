package com.example.modules.JdbcTemplate.dao.impl;

import com.example.modules.JdbcTemplate.dao.ArticleDao;
import com.example.modules.JdbcTemplate.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleDaoJdbcTemplateImpl implements ArticleDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int insertArticle(Article article) {
        String sql="insert into article (id,title,summary,status,type,userId) values (:id,:title,:summary,:status,:type,:userId)";

        Map<String,Object> param=new HashMap<>();
        param.put("id",article.getId());
        param.put("title",article.getTitle());
        param.put("summary",article.getSummary());
        param.put("status",article.getStatus());
        param.put("type",article.getType());
        param.put("userId",article.getUserId());

        return jdbcTemplate.update(sql,param);
    }
}
