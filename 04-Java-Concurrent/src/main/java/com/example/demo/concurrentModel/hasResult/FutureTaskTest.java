package com.example.demo.concurrentModel.hasResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试FutureTask获取异步结果
 * @author xingang
 * @since 2024/8/5
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "测试FutureTask获取异步结果";
            }
        });

        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException("发生中断" + e);
        } catch (ExecutionException e) {
            throw new RuntimeException("执行发生错误" + e);
        }
    }
}
