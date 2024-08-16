package com.example.demo.config;

import com.example.demo.interceptor.ExampleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author wangxingang
 * @since 2024/8/9
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ExampleInterceptor())
                .addPathPatterns("/example/**") // 拦截的路径
                .excludePathPatterns("/example/exclude/**"); // 排除的路径
    }
}
