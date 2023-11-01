package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrate that sleep does not release lock
 * (lock needs to be released manually)
 */
public class SleepDontReleaseLock implements Runnable{
    private static final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println("Thread " + Thread.currentThread().getName() + " got the lock.");
        try {
            Thread.sleep(5000);
            System.out.println("Thread " + Thread.currentThread().getName() + " was waked up");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " release the lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock sleepDontReleaseLock = new SleepDontReleaseLock();
        new Thread(sleepDontReleaseLock, "one").start();
        new Thread(sleepDontReleaseLock, "two").start();
    }
}
