package org.kenny.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Avoid deadlocks with tryLock
 */
public class TryLockDeadLock implements Runnable {
    int flag = 1;
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        TryLockDeadLock r1 = new TryLockDeadLock();
        TryLockDeadLock r2 = new TryLockDeadLock();
        r1.flag = 1;
        r2.flag = 0;
        new Thread(r1).start();
        new Thread(r2).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (flag == 1) {
                try {
                    if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 1 get the lock 1");
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                            System.out.println("Thread 1 get the lock 2");
                            System.out.println("Thread 1 get both of locks successfully");
                            lock2.unlock();
                            lock1.unlock();
                            break;
                        } else {
                            System.out.println("Thread 1 tried to get lock 2, BUT, failed. already re-tried, and will release lock 1");
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }

                    } else {
                        System.out.println("Thread 1 fail to get the lock 1, already re-tried");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (flag == 0) {
                try {
                    if (lock2.tryLock(3000, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 2 get the lock 2");

                        Thread.sleep(new Random().nextInt(1000));
                        if (lock1.tryLock(3000, TimeUnit.MILLISECONDS)) {
                            System.out.println("Thread 2 get the lock 1");
                            System.out.println("Thread 2 get both of locks successfully");
                            lock1.unlock();
                            lock2.unlock();
                            break;
                        } else {
                            System.out.println("Thread 2 tried to get lock 1, BUT, failed. already re-tried,  and will release lock 2");
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }

                    } else {
                        System.out.println("Thread 2 fail to get the lock 2, already re-tried");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
