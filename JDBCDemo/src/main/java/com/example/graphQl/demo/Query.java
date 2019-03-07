package com.example.graphQl.demo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.ArrayList;
import java.util.List;

public class Query implements GraphQLQueryResolver {
    public User getUser(){
        return new User(1,"张三");
    }
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"张三"));
        users.add(new User(2,"李四"));
        users.add(new User(3,"王五"));
        return users;
    }

}
