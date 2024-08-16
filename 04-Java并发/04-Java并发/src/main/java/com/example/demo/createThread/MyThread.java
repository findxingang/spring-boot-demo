package com.example.demo.createThread;

/**
 * 通过继承Thread类来创建线程
 * @author xingang
 * @since 2024/8/2
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }


    public static void main(String[] args) {
        // 创建线程
        MyThread thread = new MyThread();
        // 启动线程
        thread.start();
    }
}
