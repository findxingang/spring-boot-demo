package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxingang
 * @since 2024/8/9
 */
@RestController
@RequestMapping("/example")
public class ExampleController {


    @GetMapping("/someApi")
    public void someApi() {
        System.out.println("你访问了一个Api");
    }
}
