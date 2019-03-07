package com.example.modules.JdbcTemplate.dao;

import com.example.SpringbootJpaDruidApplication;
import com.example.modules.JPA.jpaRepository.ArticleRepository;
import com.example.modules.JdbcTemplate.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = SpringbootJpaDruidApplication.class)
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;


    @Test
    public void testInsert() {
//        private Long id;
//        private String title;
//        private String summary;
//        private Integer status;
//        private Integer type;
//        private Long userId;

        Article article = new Article();
        article.setId((long) 3);
        article.setTitle("测试标题3");
        article.setSummary("测试摘要3");
        article.setStatus(1);
        article.setType(6);
        article.setUserId((long) 996);

        articleDao.insertArticle(article);
    }


}