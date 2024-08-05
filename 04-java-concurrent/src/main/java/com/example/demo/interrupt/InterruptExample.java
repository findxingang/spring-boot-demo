package com.example.demo.interrupt;

/**
 * 线程中断示例
 * @author xingang
 * @since 2024/8/5
 */
public class InterruptExample {

    /**
     * 一次放开一个方法
     * @param args
     */
    public static void main(String[] args) {
        // 父线程中断子线程
        // parentInterruptsChild();

        // 子线程中断父线程
        // childInterruptsParent();

        // 第三方线程中断目标线程
        thirdPartyInterrupts();
    }

    /**
     * 第三方线程中断目标线程
     */
    private static void thirdPartyInterrupts() {
        // 要中断的线程，这个线程处理中断操作
        Thread targetThread = new Thread(() -> {
            try {
                Thread.sleep(10000); // 模拟长时间运行的任务
            } catch (InterruptedException e) {
                System.out.println("Target thread was interrupted.");
            }
        });

        targetThread.start();

        // 这个线程去发起中断操作
        Thread thirdPartyThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // 等待一段时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            targetThread.interrupt(); // 第三方线程中断目标线程
        });

        thirdPartyThread.start();
    }

    /**
     * 子线程中断父线程
     */
    private static void childInterruptsParent() {
        Thread parentThread = Thread.currentThread();

        Thread childThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // 子线程等待一段时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parentThread.interrupt(); // 子线程中断父线程
        });

        childThread.start();

        try {
            Thread.sleep(10000); // 父线程模拟长时间运行的任务
        } catch (InterruptedException e) {
            System.out.println("Parent thread was interrupted.");
        }
    }

    /**
     * 父线程中断子线程，子线程处理自身被中断的逻辑
     */
    private static void parentInterruptsChild() {
        Thread childThread = new Thread(() -> {
            try {
                Thread.sleep(10000); // 模拟长时间运行的任务
            } catch (InterruptedException e) {
                System.out.println("Child thread was interrupted.");
            }
        });

        childThread.start();

        try {
            Thread.sleep(2000); // 父线程等待一段时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        childThread.interrupt(); // 父线程中断子线程
    }
}
