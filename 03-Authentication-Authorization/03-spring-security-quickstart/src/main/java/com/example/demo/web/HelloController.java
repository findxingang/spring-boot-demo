package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxingang
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        System.out.println("\nHello World\n");
        return "Hello World";
    }
}
