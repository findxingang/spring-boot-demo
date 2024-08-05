package com.example.demo.concurrentModel.noResult;

/**
 * 定义回调接口
 * @author xingang
 * @since 2024/8/5
 */
public interface TaskCallable<T> {
    T callable(T t);
}
