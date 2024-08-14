package com.example.demo.session.service;

import com.example.demo.doamin.User;
import com.example.demo.session.utils.RequestContext;
import org.springframework.stereotype.Service;

/**
 * @author wangxingang
 * @since 2024/8/14
 */
@Service
public class UserService {

    public void doSomething() {
        User user = RequestContext.getCurrentUser();
        System.out.println("service层---当前登录用户对象：" + user);
    }
}
