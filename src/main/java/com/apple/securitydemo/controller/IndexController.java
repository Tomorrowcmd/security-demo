package com.apple.securitydemo.controller;



import com.apple.securitydemo.entity.User;
import com.apple.securitydemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: IndexController
 * Package: security-demo
 * Description:
 *
 * @Author IT-Tomorrow
 * @Create 2024/2/4 17:29
 * @Version 1.0
 */
@RestController
public class IndexController {


    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
