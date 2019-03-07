package com.example.modules.JPA.jpaRepository;

import com.example.modules.JdbcTemplate.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("select art from com.example.modules.JdbcTemplate.entity.Article art ")
    public List<Article> findAllByUserId();

    @Query("select art from com.example.modules.JdbcTemplate.entity.Article art where title=:title")
    public List<Article> queryByTitle(@Param("title")String title);

}
