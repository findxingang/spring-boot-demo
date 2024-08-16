package com.example.demo.interrupt;

/**
 * 中断一个线程
 * @author xingang
 * @since 2024/8/5
 */
public class InterruptedExceptionExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is going to sleep for 5 seconds.");
                Thread.sleep(5000); // 线程进入休眠状态
                System.out.println("Thread woke up.");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep.");
            }
        });

        thread.start();

        try {
            Thread.sleep(2000); // 主线程休眠2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 中断子线程
    }
}
