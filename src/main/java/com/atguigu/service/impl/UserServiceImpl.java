package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public List<User> findAll() {
        //从缓存中查询数据  规定存储用户信息使用string类型进行存储, 存储的key就是userList
        List<User> users = (List<User>) redisTemplate.boundValueOps("userList").get();
        if (users == null || users.size() == 0) {
            users = userMapper.selectAll();
            redisTemplate.boundValueOps("userList").set(users);
            System.out.println("从数据库中取值：" + users);
        }else {
            System.out.println("从缓存中取值：" + users);
        }
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,noRollbackFor =  FileNotFoundException.class)
    public void addUser(User user) throws FileNotFoundException {
        userMapper.insertSelective(user);
//        int i = 1/0;
        List<User> userList = userMapper.select(user);
        System.out.println(userList.get(0));
//        throw new FileNotFoundException();

    }
}
