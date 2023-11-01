package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Outputs the current time every 1 second, is interrupted, and observes it.
 * Thread.sleep()
 * TimeUnit.SECONDS.sleep()
 */
public class SleepInterrupted implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(6500);
        thread.interrupt();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                System.out.println("I was interrupted!!!");
                throw new RuntimeException(e);
            }
        }
    }
}
