package com.example.demo.concurrentModel.noResult;

/**
 * 任务执行
 * @author xingang
 * @since 2024/8/5
 */
public class TaskExecutor implements Runnable{
    private final TaskCallable<TaskResult> taskCallable;
    private final String taskParameter;

    public TaskExecutor(TaskCallable<TaskResult> taskCallable, String taskParameter) {
        this.taskCallable = taskCallable;
        this.taskParameter = taskParameter;
    }

    @Override
    public void run() {
        // 一系列业务逻辑，将结果数据封装成TaskResult对象并返回
        TaskResult result = new TaskResult();
        result.setTaskStatus(1);
        result.setTaskMessage("参数有：" + taskParameter);
        result.setTaskResult("异步回调成功");
        // 执行完毕后调用回调函数
        taskCallable.callable(result);
    }
}
