package com.example;


import com.example.demo.jwt.interceptor.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangxingang
 * @since 2024/8/14
 */
@SpringBootApplication
public class JwtApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 使拦截器生效
        registry.addInterceptor(new LoginInterceptor());
    }
}