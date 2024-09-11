package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.CustomUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.CustomUserService;
import org.springframework.stereotype.Service;

/**
 * @author wangxingang
 */
@Service
public class CustomUserServiceImpl extends ServiceImpl<UserMapper, CustomUser> implements CustomUserService {

    // @Resource
    // private DBUserDetailsManager dbUserDetailsManager;
    //
    @Override
    public void saveUserDetails(CustomUser customUser) {
    //
    //     UserDetails userDetails = org.springframework.security.core.userdetails.User
    //             .withDefaultPasswordEncoder()
    //             .username(customUser.getUsername()) //自定义用户名
    //             .password(customUser.getPassword()) //自定义密码
    //             .authorities(new ArrayList<>())
    //             .build();
    //     dbUserDetailsManager.createUser(userDetails);
    }

    @Override
    public CustomUser findByUsername(String username) {
        // 根据用户名去数据库中查询用户
        QueryWrapper<CustomUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        CustomUser customUser = baseMapper.selectOne(queryWrapper);
        return customUser;
    }
}