package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * Demonstrates printing the main thread, thread-0, thread-1
 */
public class CurrentThread implements Runnable{
    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
