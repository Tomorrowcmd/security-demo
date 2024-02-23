package com.apple.securitydemo.config;

import com.apple.securitydemo.entity.User;

import com.apple.securitydemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: DBUserDetailsManager
 * Package: security-demo
 * Description: 基于数据实现校验
 *
 * @Author IT-Tomorrow
 * @Create 2024/2/5 14:45
 * @Version 1.0
 */
@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public void createUser(UserDetails user) {

    }

    /**
     * 插入用户信息
     * @param userDetails
     */
    @Override
    public void updateUser(UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEnabled(true);
        userMapper.insert(user);
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    /**
     * 从数据库中获取用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (user == null){
            throw new UsernameNotFoundException(username);
        }else {

            Collection<GrantedAuthority> authorities = new ArrayList<>();

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    user.getEnabled(),
                    true,//用户账号是否过期
                    true,//用户凭证是否过期
                    true,//用户是否被锁定
                    authorities);
        }
    }
}
