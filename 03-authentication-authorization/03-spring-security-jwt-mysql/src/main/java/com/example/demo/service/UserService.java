package com.example.demo.service;

import com.example.demo.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
* @author 王新刚
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2024-08-08 09:28:27
*/
public interface UserService extends IService<User> {

    Optional<User> findByUsernameOrEmail(String username, String email);
}
