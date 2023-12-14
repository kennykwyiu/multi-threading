package org.kenny.adcanced.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class LockInterruptably implements Runnable {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptably lockInterruptably = new LockInterruptably();
        Thread thread0 = new Thread(lockInterruptably);
        Thread thread1 = new Thread(lockInterruptably);
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " try to get the lock");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + " get the lock");
                Thread.sleep(5000); // don't let other threads get the lock easily
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted when the thread was sleeping");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " release the lock");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted when the thread was getting the lock");
        }
    }
}
