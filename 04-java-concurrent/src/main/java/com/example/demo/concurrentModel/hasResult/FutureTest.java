package com.example.demo.concurrentModel.hasResult;

import java.util.concurrent.*;

/**
 * 测试Future获取异步结果
 * @author xingang
 * @since 2024/8/5
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "测试Future获取异步结果";
            }
        });
        System.out.println(future.get());
        executorService.shutdown();
    }
}
