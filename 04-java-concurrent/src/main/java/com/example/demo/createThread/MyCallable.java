package com.example.demo.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口的使用方法
 * @author xingang
 * @since 2024/8/2
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Callable executed";
    }

    public static void main(String[] args) {
        // 利用`FutureTask`类将`Callable`任务提交到线程中执行
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        // `FutureTask`类实现了`Runnable`接口和`Future`接口
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // 获取`Callable`任务的执行结果
            String callableResult = futureTask.get();
            System.out.println(callableResult);

            // FutureTask的get()方法是Future接口get()方法的重载方法，会抛出一样的异常类型
            // 下边这两个异常都是Future接口get()方法会抛出的异常
        } catch (InterruptedException e) {
            throw new RuntimeException("当前线程在等待时被中断" + e);
        } catch (ExecutionException e) {
            throw new RuntimeException("计算抛出异常" + e);
        }
    }
}
