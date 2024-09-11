package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.CustomUser;

/**
 * @author wangxingang
 */
public interface CustomUserService extends IService<CustomUser> {
    void saveUserDetails(CustomUser customUser);

    CustomUser findByUsername(String username);
}
