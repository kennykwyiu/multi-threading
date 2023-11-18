package org.kenny.hm_thread_demo.a13waitandnotify;

public class Cook extends Thread {
    public Cook() {
    }

    public Cook(String name) {
        super(name);
    }

    @Override
    public void run() {

        // 1. loop
        // 2. syn block or method
        // 3. determine shared quantity is zero or not (zero)
        // 4. determine shared quantity is zero or not (not zero, run the core logic)

        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.foodFlag == 1) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("Cook cooked one food and put it on the desk");
                        Desk.foodFlag = 1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }

    }
}
