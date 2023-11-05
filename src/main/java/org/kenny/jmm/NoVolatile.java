package org.kenny.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Scenarios where volatile is not applicable
 */
public class NoVolatile implements Runnable {
    volatile int a;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile runnable = new NoVolatile();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(runnable.a);
        System.out.println(runnable.realA.get());
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            a++;
            realA.incrementAndGet();
        }
    }
}
