package com.example.demo.concurrentModel.hasResult;

import java.util.concurrent.*;

/**
 * 结合线程池使用 FutureTask
 * @author xingang
 * @since 2024/8/5
 */
public class FutureTaskTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "测试FutureTask获取异步结果";
            }
        });
        executorService.execute(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();
    }
}
