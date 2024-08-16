package com.example.demo.config;

import com.example.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xingang
 * @since 2024/7/18 10:26
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义的拦截器
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*");
    }
}
