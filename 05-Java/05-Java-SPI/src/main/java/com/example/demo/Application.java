package com.example.demo;

import com.example.demo.spi.MyService;

import java.net.UnknownHostException;
import java.util.ServiceLoader;

public class Application {

    public static void main(String[] args) throws UnknownHostException {
        // 加载服务提供者
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for (MyService service : serviceLoader) {
            // 根据需要调用不同的服务实现
            service.performService();
        }
    }

}
