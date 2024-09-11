package com.example.demo.spi;

/**
 * 服务提供者实现接口
 * @author wangxingang
 */
public class MyServiceImpl implements MyService{
    @Override
    public void performService() {
        System.out.println("我是 MyServiceImpl，执行了我的 performService() 方法");
    }
}
