package org.kenny.hm_thread_demo.a10threadsafe2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    static int ticket = 0;

    static Lock lock = new ReentrantLock();

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    // 1. loop
    // 2. syn block or method
    // 3. determine shared data is to the end or not, if it's the end now
    // 4. determine shared data is to the end or not, if it is NOT the end now

    @Override
    public void run() {
        // 1. loop
        while (true) {
            // 2. syn block or method
//            synchronized (this) {
            lock.lock();
            // 3. determine shared data is to the end or not, if it's the end now
            try {
                if (ticket == 100) {
                    break;
                } else {
                    // 4. determine shared data is to the end or not, if it is NOT the end now
                    Thread.sleep(10);

                    ticket++;
                    System.out.println(Thread.currentThread().getName() + " is selling #" + ticket + " ticket!!!");
                }
//            }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();

            }
        }

    }

}
