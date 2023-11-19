package org.kenny.hm_thread_demo.test4case2_RedPocket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread extends Thread {
    //    share data
    //    $100, and divided into 3 red pockets

    static BigDecimal money = new BigDecimal("100");
    static int count = 3;

    // min amount of red pocket
    static final BigDecimal MIN = new BigDecimal("0.01");

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
                BigDecimal prize;
                if (count == 1) {
                    prize = money;
                } else {
                    Random random = new Random();
                    // 100 , 3
                    // 1st: 99.98
                    // 100 - (3 -1) * 0.01
                    double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                    prize = BigDecimal.valueOf(random.nextDouble() * bounds)
                            .setScale(2, RoundingMode.HALF_UP);
//                    if (prize < MIN) {
//                        prize = MIN;
//                    }
                }

                money = money.subtract(prize);
                count--;
                System.out.println(getName() + " gets " + prize + " dollars");

            }
        }

    }
}
