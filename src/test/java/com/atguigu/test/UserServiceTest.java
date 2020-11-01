package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findAll() {
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }

    @Test
    public void addUser() throws FileNotFoundException {
        userService.addUser(new User(null,"张三","男",18,"111","110","112","zhangsan11","120"));
    }
}
