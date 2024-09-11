package com.example.demo.spi;

/**
 * 另一个服务提供者实现接口
 * @author wangxingang
 */
public class MyAnotherServiceImpl implements MyService{
    @Override
    public void performService() {
        System.out.println("我是 MyAnotherServiceImpl，执行了我的 performService() 方法");
    }
}
