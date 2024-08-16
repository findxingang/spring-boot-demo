package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* @author 王新刚
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2024-08-08 09:28:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {

        return baseMapper.selectByUsernameOrEmail(username, email);
        // LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
        //         .eq(User::getName, username)
        //         .or()
        //         .eq(User::getEmail, email);
        // return this.getOneOpt(queryWrapper);
    }
}




