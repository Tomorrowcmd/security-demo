package com.apple.securitydemo.controller;

import com.apple.securitydemo.entity.User;
import com.apple.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserController
 * Package: security-demo
 * Description:
 *
 * @Author IT-Tomorrow
 * @Create 2024/2/5 14:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    public UserService userService;

    @GetMapping("/list")
    public List<User> getList(){
        return userService.list();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.saveUserDetails(user);
    }
}
