package org.kenny.background;

import java.util.concurrent.TimeUnit;

/**
 * Chapter 2, Thread Safety Issues, demonstrates deadlock.
 */
public class MultiThreadErrorDeadLock implements Runnable{

    int flag = 1;
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        MultiThreadErrorDeadLock runnable1 = new MultiThreadErrorDeadLock();
        MultiThreadErrorDeadLock runnable2 = new MultiThreadErrorDeadLock();
        runnable1.flag = 1;
        runnable2.flag = 0;
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": flag = " + flag);
        if (flag == 1) {
            synchronized (object1) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (object2) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("0");
                }
            }
        }
    }
}
