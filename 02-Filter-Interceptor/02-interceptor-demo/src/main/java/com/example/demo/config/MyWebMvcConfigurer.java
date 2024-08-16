package com.example.demo.config;

import com.example.demo.interceptor.MyInterceptor1;
import com.example.demo.interceptor.MyInterceptor2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
@Configuration
@Slf4j
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
        //注入2个拦截器,并设置优先级
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/interceptor/*").order(2);
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/interceptor/*").order(1);
    }
}
