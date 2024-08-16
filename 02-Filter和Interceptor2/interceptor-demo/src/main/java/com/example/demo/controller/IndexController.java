package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xingang
 * @since 2024/7/18 10:08
 */
@RestController
public class IndexController {

    @GetMapping("/interceptor")
    public String index() {
        return "Hello, Spring MVC Interceptor!";
    }
}
