package com.example.demo.config;

import com.example.demo.filter.MyFilter1;
import com.example.demo.filter.MyFilter2;
import com.example.demo.filter.MyFilter3;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
@Configuration
public class FilterConfig {

    // 当然也可以省略 @Bean，改为在 3 个 MyFilter 类上添加 @Component
    // @Bean
    // MyFilter1 myFilter1() {
    //     return new MyFilter1();
    // }
    //
    // @Bean
    // MyFilter2 myFilter2() {
    //     return new MyFilter2();
    // }
    //
    // @Bean
    // MyFilter3 myFilter3() {
    //     return new MyFilter3();
    // }
    //
    // @Bean
    // public FilterRegistrationBean<MyFilter1> getFilterRegistrationBean1(MyFilter1 myFilter1) {
    //     FilterRegistrationBean<MyFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
    //     filterRegistrationBean.setFilter(myFilter1);
    //     // 设置优先级，则以此为准，数字越小，优先级越高，当设置数字相同时，依然按照配置顺序执行
    //     // filterRegistrationBean.setOrder(3);
    //     // 设置过滤URL
    //     filterRegistrationBean.addUrlPatterns("/hello");
    //     return filterRegistrationBean;
    // }
    //
    // @Bean
    // public FilterRegistrationBean<MyFilter2> getFilterRegistrationBean2(MyFilter2 myFilter2) {
    //     FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
    //     filterRegistrationBean.setFilter(myFilter2);
    //     // 设置优先级，则以此为准，数字越小，优先级越高，当设置数字相同时，依然按照配置顺序执行
    //     // filterRegistrationBean.setOrder(2);
    //     // 设置过滤URL
    //     filterRegistrationBean.addUrlPatterns("/*");
    //     return filterRegistrationBean;
    // }
    //
    // @Bean
    // public FilterRegistrationBean<MyFilter3> getFilterRegistrationBean3(MyFilter3 myFilter3) {
    //     FilterRegistrationBean<MyFilter3> filterRegistrationBean = new FilterRegistrationBean<>();
    //     filterRegistrationBean.setFilter(myFilter3);
    //     // 设置优先级，则以此为准，数字越小，优先级越高，当设置数字相同时，依然按照配置顺序执行
    //     // filterRegistrationBean.setOrder(1);
    //     // 设置过滤URL
    //     filterRegistrationBean.addUrlPatterns("/bye");
    //     return filterRegistrationBean;
    // }

    @Bean
    public FilterRegistrationBean<MyFilter1> getFilterRegistrationBean1() {
        FilterRegistrationBean<MyFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter1()); // 注意这里是 new 出来的，没有用 Spring 注入
        // 设置优先级，则以此为准，数字越小，优先级越高，当设置数字相同时，依然按照配置顺序执行
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> getFilterRegistrationBean2() {
        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter2()); // 注意这里是 new 出来的，没有用 Spring 注入
        // 设置优先级，则以此为准，数字越小，优先级越高，当设置数字相同时，依然按照配置顺序执行
        filterRegistrationBean.setOrder(2);
        // 设置过滤URL
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter3> getFilterRegistrationBean3() {
        FilterRegistrationBean<MyFilter3> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter3()); // 注意这里是 new 出来的，没有用 Spring 注入
        // 设置优先级，则以此为准，数字越小，优先级越高，当设置数字相同时，依然按照配置顺序执行
        filterRegistrationBean.setOrder(1);
        // 设置过滤URL
        filterRegistrationBean.addUrlPatterns("/bye");
        return filterRegistrationBean;
    }
}
