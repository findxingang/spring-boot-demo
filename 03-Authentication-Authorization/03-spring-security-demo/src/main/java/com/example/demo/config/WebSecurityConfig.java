package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author wangxingang
 */
@Configuration
// @EnableWebSecurity // Spring项目总需要添加此注解，SpringBoot项目中不需要
public class WebSecurityConfig {

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     // 基于内存的用户认证
    //     InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //     manager.createUser( // 此行设置断点可以查看创建的user对象
    //             User
    //                     .withDefaultPasswordEncoder()
    //                     .username("huan") // 自定义用户名
    //                     .password("password") // 自定义密码
    //                     .roles("USER") // 自定义角色
    //                     .build()
    //     );
    //     return manager;
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     // 基于数据库的用户认证
    //     DBUserDetailsManager manager = new DBUserDetailsManager();
    //     return manager;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // authorizeRequests()：开启授权保护
        // anyRequest()：对所有请求开启授权保护
        // authenticated()：已认证请求会自动被授权
        http
                .csrf().disable()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/demo/user/add").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults()) // 表单授权方式
                .httpBasic(Customizer.withDefaults()); // 基本授权方式

        return http.build();
    }
}
