package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello() {
        String str = "hello";
        logger.info(str);
        return str;
    }

    @RequestMapping("/bye")
    public String bye() {
        String str = "bye";
        logger.info(str);
        return str;
    }
}
