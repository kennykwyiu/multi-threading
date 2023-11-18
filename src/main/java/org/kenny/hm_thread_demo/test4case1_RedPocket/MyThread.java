package org.kenny.hm_thread_demo.test4case1_RedPocket;

import java.util.Random;

public class MyThread extends Thread {
    //    share data
    //    $100, and divided into 3 red pockets
    static double money = 100;
    static int count = 3;

    // min amount of red pocket
    static final double MIN = 0.01;

    @Override
    public void run() {
        // loop
        // syn block
        // condition, shared data to the end (yes)
        // condition, shared data to the end (no)

        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(getName() + " cannot get the red pocket");
            } else {
                double prize = 0;
                if (count == 1) {
                    prize = money;
                } else {
                    Random random = new Random();
                    // 100 , 3
                    // 1st: 99.98
                    // 100 - (3 -1) * 0.01
                    double bounds = money - (count - 1) * MIN;
                    prize = random.nextDouble() * bounds;
                    if (prize < MIN) {
                        prize = MIN;
                    }
                }

                money = money - prize;
                count--;
                System.out.println(getName() + " gets " + prize + " dollars");

            }
        }

    }
}
