package com.apple.securitydemo.service;

import com.apple.securitydemo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    void saveUserDetails(User user);
}