package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * Two threads alternately print odd and even numbers from 0 to 100,
 * implemented with the synchronized keyword.
 * This is the classic interview question.
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count;
    private static final Object lock = new Object();

    //create 2 new threads
    //thread 1 handles only even numbers, the second handles only odd numbers (with bitwise arithmetic)
    //communicate with synchronized
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " get the lock at " + count);
//                         if ((count & 1) == 0) {
                        if (count % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + " : " + count++);
                        }
                    }
                }
            }
        }, "Even").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " get the lock at " + count);

//                         if ((count & 1) == 1) {
                        if (count % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + " : " + count++);
                        }
                    }
                }
            }
        }, "Odd").start();
    }
}
