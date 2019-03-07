package com.example.modules.myBatis.dao;

import com.example.SpringbootJpaDruidApplication;
import com.example.modules.JdbcTemplate.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = SpringbootJpaDruidApplication.class)
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testQueryById(){
        List<Article> articleList=articleMapper.queryById((long) 1);
        System.out.printf("article :"+ articleList);
    }

    @Test
    public void testInsertArticle(){
        Article article = new Article();
        article.setId((long) 5);
        article.setTitle("测试标题5");
        article.setSummary("测试摘要5");
        article.setStatus(1);
        article.setType(6);
        article.setUserId((long) 994);

        articleMapper.insertArticle(article);

        List<Article> articleList=articleMapper.queryById((long) 5);
        System.out.printf("the article is :"+ articleList);
    }

    @Test
    public void testUpdateArticle(){
        List<Article> articleList=articleMapper.queryById((long) 1);
        System.out.printf("the after article is :"+ articleList);
        articleList.get(0).setSummary("测试修改");
        articleList.get(0).setStatus(2);
        articleMapper.updateArticle(articleList.get(0));
        articleList=articleMapper.queryById((long) 1);
        System.out.printf("the befor article is :"+ articleList);

    }
}
