package com.example.demo.concurrentModel.noResult;

/**
 * 测试效果
 * @author xingang
 * @since 2024/8/5
 */
public class TaskCallableTest {
    public static void main(String[] args) {
        TaskCallable<TaskResult> taskCallable = new TaskHandler();
        TaskExecutor taskExecutor = new TaskExecutor(taskCallable, "测试回调任务");
        new Thread(taskExecutor).start();
    }
}
