package com.example.demo.concurrentModel.noResult;

import lombok.Data;

/**
 * 线程任务执行结果
 * @author xingang
 * @since 2024/8/5
 */
@Data
public class TaskResult {
    /**
     * 任务状态
     */
    private Integer taskStatus;
    /**
     * 任务消息
     */
    private String taskMessage;
    /**
     * 任务结果数据
     */
    private String taskResult;
}