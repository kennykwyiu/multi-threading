package org.kenny.threadcoreknowledge.uncaughtexception;

import java.util.concurrent.TimeUnit;

public class UseOwnUncaughtExceptionHandler implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("Handler1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        TimeUnit.MILLISECONDS.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        TimeUnit.MILLISECONDS.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        TimeUnit.MILLISECONDS.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();

    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
