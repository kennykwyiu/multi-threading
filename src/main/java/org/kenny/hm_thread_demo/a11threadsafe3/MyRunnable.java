package org.kenny.hm_thread_demo.a11threadsafe3;

public class MyRunnable implements Runnable {

    int ticket = 0;

    // 1. loop
    // 2. syn block or method
    // 3. determine shared data is to the end or not, if it's the end now
    // 4. determine shared data is to the end or not, if it is NOT the end now

    @Override
    public void run() {
        // 1. loop
        while (true) {
            if (hasTicket()) break;
        }

    }

    // 2. syn block or method
    // this
    private synchronized boolean hasTicket() {
        // 3. determine shared data is to the end or not, if it's the end now
        if (ticket == 100) {
            return true;
        } else {
            // 4. determine shared data is to the end or not, if it is NOT the end now
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + " is selling #" + ticket + " ticket!!!");
        }
        return false;
    }
}
