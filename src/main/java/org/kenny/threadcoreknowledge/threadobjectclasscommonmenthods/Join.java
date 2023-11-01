package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

import java.util.concurrent.TimeUnit;

/**
 * Demonstrate join, order of code will induce the order of output
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished process.");
            }
        }, "Thread 1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished process.");
            }
        }, "Thread 2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished process.");
            }
        }, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Start to wait for sub-thread to finish");
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("All threads were finished");
    }
}
/*
Start to wait for sub-thread to finish
Thread 1 finished process.
Thread 3 finished process.
Thread 2 finished process.
All threads were finished
 */

/*
if no join
Start to wait for sub-thread to finish
All threads were finished
Thread 1 finished process.
Thread 3 finished process.
Thread 2 finished process.
 */