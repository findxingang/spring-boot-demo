package com.example.demo.concurrentModel.noResult;

/**
 * 回调函数的实现类
 * @author xingang
 * @since 2024/8/5
 */
public class TaskHandler implements TaskCallable<TaskResult>{
    @Override
    public TaskResult callable(TaskResult taskResult) {
        // 拿到结果后可以进一步处理，这里只打印
        System.out.println(taskResult.toString());
        return taskResult;
    }
}
