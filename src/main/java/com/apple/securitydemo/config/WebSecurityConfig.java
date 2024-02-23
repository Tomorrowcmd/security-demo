package com.apple.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * ClassName: WebSecurityConfig
 * Package: security-demo
 * Description: 基于内存实现自定义校验
 *
 * @Author IT-Tomorrow
 * @Create 2024/2/4 18:07
 * @Version 1.0
 */
@Configuration
//@EnableWebSecurity//Spring项目总需要添加此注解，SpringBoot项目中不需要
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        //创建基于内存的用户信息管理器
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser( //此行设置断点可以查看创建的user对象
//                User
//                        .withDefaultPasswordEncoder()
//                        .username("huan") //自定义用户名
//                        .password("123456") //自定义密码
//                        .roles("USER") //自定义角色
//                        .build()
//        );
//        return manager;
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        //创建基于数据库的用户信息管理器
//        DBUserDetailsManager dbUserDetailsManager = new DBUserDetailsManager();
//
//        return dbUserDetailsManager;
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //authorizeRequests()：开启授权保护
        //anyRequest()：对所有请求开启授权保护
        //authenticated()：已认证请求会自动被授权
        http
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .formLogin(withDefaults());//表单授权方式
                //.httpBasic(withDefaults());//基本授权方式

        http.csrf(csrf -> csrf.disable()); //关闭csrf防御模式

        return http.build();
    }
}
