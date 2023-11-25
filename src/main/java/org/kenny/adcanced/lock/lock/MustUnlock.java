package org.kenny.adcanced.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock does not automatically release the lock in case of an exception, unlike synchronized.
 * Therefore, it is considered a best practice to release the lock in the finally block
 * to ensure that the lock is always released even if an exception occurs.
 */
public class MustUnlock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            // Obtaining access to the resource protected by this lock means that after acquiring the lock,
            // it is safe to access the resource that is protected by the lock.
            System.out.println(Thread.currentThread().getName() + " start to execute the code");
        } finally {
            lock.unlock();
        }
    }
}
