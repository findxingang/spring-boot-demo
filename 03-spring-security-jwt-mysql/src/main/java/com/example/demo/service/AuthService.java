package com.example.demo.service;

import com.example.demo.dto.LoginDto;

/**
 * @author wangxingang
 * @since 2024/8/8
 */
public interface AuthService {
    String login(LoginDto loginDto);
}
