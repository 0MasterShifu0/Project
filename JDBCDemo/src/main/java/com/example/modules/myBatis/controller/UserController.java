package com.example.modules.myBatis.controller;

import com.example.modules.myBatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}")
    public Object findById(@PathVariable Long id){
        return userService.findById(id);

    }
}
