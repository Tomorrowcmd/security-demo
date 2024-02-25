package com.apple.securitydemo.service.impl;

import com.apple.securitydemo.config.DBUserDetailsManager;
import com.apple.securitydemo.entity.User;
import com.apple.securitydemo.mapper.UserMapper;
import com.apple.securitydemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public void saveUserDetails(User user) {

        UserDetails userDetails =  org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .username(user.getUsername()) //自定义用户名
                .password(user.getPassword()) //自定义密码
                .build();

        dbUserDetailsManager.createUser(userDetails);
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello git");
        System.out.println("hello git master-test");
    }
}