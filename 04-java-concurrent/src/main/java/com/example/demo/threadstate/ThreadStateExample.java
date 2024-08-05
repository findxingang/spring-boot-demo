package com.example.demo.threadstate;

/**
 * 线程的六种状态
 * @author xingang
 * @since 2024/8/5
 */
public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        // 输出：NEW
        Thread thread1 = new Thread(() -> { /* do something */ });
        System.out.println(thread1.getState());

        // 输出：RUNNABLE
        Thread thread2 = new Thread(() -> {
            while (true) {
            }
        });
        thread2.start();
        System.out.println(thread2.getState());

        // 输出：BLOCKED
        blocked();

        // 输出：WAITING
        waiting();

        // 输出：TIMED_WAITING
        timedWaiting();

        // 输出：TERMINATED
        terminated();
    }

    private static void terminated() throws InterruptedException {
        Thread thread = new Thread(() -> { /* do something */ });
        thread.start();
        thread.join();  // 等待线程执行完毕
        System.out.println(thread.getState());  // 输出：TERMINATED
    }

    private static void timedWaiting() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        });

        thread.start();
        Thread.sleep(100);  // 确保 thread 进入 sleep 状态
        System.out.println(thread.getState());  // 输出：TIMED_WAITING
    }

    private static void waiting() throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException ignored) {
                }
            }
        });

        thread.start();
        Thread.sleep(100);  // 确保 thread 已进入 wait 状态
        System.out.println(thread.getState());  // 输出：WAITING
    }


    private static void blocked() throws InterruptedException {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
            }
        });

        thread1.start();
        Thread.sleep(100);  // 确保 thread1 先获取到锁
        thread2.start();
        Thread.sleep(100);  // 确保 thread2 尝试获取锁
        System.out.println(thread2.getState());  // 输出：BLOCKED
    }
}
