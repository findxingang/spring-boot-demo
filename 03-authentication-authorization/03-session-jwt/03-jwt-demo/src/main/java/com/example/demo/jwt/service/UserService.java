package com.example.demo.jwt.service;

import com.example.demo.jwt.utils.UserContext;
import org.springframework.stereotype.Service;

/**
 * @author wangxingang
 * @since 2024/8/14
 */
@Service
public class UserService {
    public void doSomething() {
        String currentUserName = UserContext.getCurrentUserName();
        System.out.println("Service层---当前用户登录名：" + currentUserName);
    }
}
