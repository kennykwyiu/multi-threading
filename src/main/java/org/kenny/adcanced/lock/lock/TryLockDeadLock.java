package org.kenny.adcanced.lock.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Avoiding Deadlocks with tryLock
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
                    if (lock1.tryLock(3000, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " get the lock1");
                            Thread.sleep(new Random().nextInt(1000));

                            if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + " get the lock2");
                                    System.out.println(Thread.currentThread().getName() + " get both of locks");
                                    break;
                                } finally {
                                    lock2.unlock();
                                }
                            } else {
                                System.out.println(Thread.currentThread().getName() + " fail to get lock2 and tried again");
                            }

                        } finally {
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " fail to get lock1 and tried again");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (flag == 0) {
                try {
                    if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " get the lock2");
                            Thread.sleep(new Random().nextInt(1000));

                            if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + " get the lock1");
                                    System.out.println(Thread.currentThread().getName() + " get both of locks");
                                    break;
                                } finally {
                                    lock1.unlock();
                                }
                            } else {
                                System.out.println(Thread.currentThread().getName() + " fail to get lock1 and tried again");
                            }

                        } finally {
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " fail to get lock2 and tried again");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
