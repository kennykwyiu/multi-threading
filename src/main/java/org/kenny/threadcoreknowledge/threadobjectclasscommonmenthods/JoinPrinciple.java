package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

import java.util.concurrent.TimeUnit;

/**
 * By explaining the principle of join,
 * implement custom join method
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished all task in run()");
            }
        }, "Thread 1");

        thread1.start();
        System.out.println("Start to wait for Thread 1 finishing.");
//        thread1.join();
        synchronized (thread1) {
            thread1.wait();
            // main thread will wait
            // and thread 1 will notify the main thread after finished run()
        }
        System.out.println("All Threads were finished!!!");
    }
}
