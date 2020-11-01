package com.atguigu.service;

import com.atguigu.pojo.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user) throws FileNotFoundException;
}
