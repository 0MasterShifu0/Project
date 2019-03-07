package com.example.modules.myBatis.dao;

import com.example.modules.JdbcTemplate.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {
    public List<Article> queryById(Long id);
    public Long insertArticle(Article article);
    public void updateArticle(Article article);
    /*public List<Article> queryArticlesByPage(@Param("article")Article article,
                                             @Param("pageSize")int pageSize ,@Param("offset")int offset);*/

}
