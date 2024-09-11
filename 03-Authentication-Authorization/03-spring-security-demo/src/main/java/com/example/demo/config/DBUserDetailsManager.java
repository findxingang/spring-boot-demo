package com.example.demo.config;

import com.example.demo.domain.CustomUser;
import com.example.demo.service.CustomUserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 基于数据库的 UserDetailsService
 * @author wangxingang
 */
@Component
public class DBUserDetailsManager implements UserDetailsManager {

    @Resource
    private CustomUserService customUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = customUserService.findByUsername(username);
        if (customUser == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new org.springframework.security.core.userdetails.User(
                    customUser.getUsername(),
                    customUser.getPassword(),
                    customUser.getEnabled(),
                    true, // 如果帐户尚未过期，则设置为true
                    true, // 如果凭证尚未过期，则设置为true
                    true, // 如果帐户未被锁定，则设置为true
                    AuthorityUtils.NO_AUTHORITIES); // 权限列表
        }
    }

    @Override
    public void createUser(UserDetails userDetails) {

    }

    @Override
    public void updateUser(UserDetails user) {

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
}
