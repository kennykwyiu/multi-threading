package org.kenny.hm_thread_demo.a13waitandnotify;

public class Foodie extends Thread {
    public Foodie() {
    }

    public Foodie(String name) {
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
                    // determine desk have food or not
                    if (Desk.foodFlag == 0) {
                        // if no, wait
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // max count - one
                        Desk.count--;
                        // if yes, eat
                        System.out.println("Foodie is eating the food,  still have " + Desk.count + " can eat!!!");
                        // finished eating, notify cook to cook again
                        Desk.lock.notifyAll();
                        // desk status be changed to zero
                        Desk.foodFlag = 0;
                    }
                }
            }
        }

    }
}
