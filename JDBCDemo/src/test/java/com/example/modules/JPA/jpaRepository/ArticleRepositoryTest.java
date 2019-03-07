package com.example.modules.JPA.jpaRepository;

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
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testQury(){
        //List<Article> article=articleRepository.queryByTitle("测试demo");
        List<Article> article=articleRepository.findAllByUserId();
        System.out.printf("article :" + article);  //快捷键sof
    }

}
