package com.example.demo.createThread;

/**
 * @author xingang
 * @since 2024/8/2
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable is running...");
    }

    public static void main(String[] args) {
        // MyRunnable对象作为Thread构造函数的参数
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
