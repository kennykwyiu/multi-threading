package org.kenny.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Situations where volatile is appropriate
 */
public class UseVolatile implements Runnable{

    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        UseVolatile runnable = new UseVolatile();
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
            setDone();
            realA.incrementAndGet();
        }
    }
    private void setDone() {
        this.done = true;
    }

}
