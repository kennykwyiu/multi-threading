package org.kenny.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Another scenario where volatile is not applicable
 */
public class UseVolatile2 implements Runnable{

    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        UseVolatile2 runnable = new UseVolatile2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(runnable.done);
        System.out.println(runnable.realA.get());
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            flipDone();
            realA.incrementAndGet();
        }
    }
    private void flipDone() {
        this.done = !done;
    }

}
