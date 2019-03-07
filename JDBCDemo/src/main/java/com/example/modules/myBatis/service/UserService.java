package com.example.modules.myBatis.service;

import com.example.modules.JdbcTemplate.entity.Article;
import com.example.modules.myBatis.dao.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> findById(Long id){
        return articleMapper.queryById(id);

    }

}
