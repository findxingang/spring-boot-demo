package com.example.demo;

/**
 * join 的用法
 * @author xingang
 * @since 2024/8/5
 */
public class ThreadJoinExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread-1 is running");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread-2 is running");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("thread-3 is running");
        });


        thread1.start();

        // 主线程等待 thread-1 执行完毕
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("thread-1执行中断", e);
        }
        thread2.start();

        // 主线程等待 thread-1 执行完毕
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("thread-2执行中断", e);
        }
        thread3.start();

    }
}
