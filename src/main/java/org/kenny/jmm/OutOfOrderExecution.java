package org.kenny.jmm;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.concurrent.CountDownLatch;

/**
 * Demonstrate the phenomenon of reordering "not stopping until a certain condition is reached" to test for small probability events.
 * Ideas are referenced from https://tech.meituan.com/2014/09/23/java-memory-reordering.html
 */
public class OutOfOrderExecution {
    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch latch = new CountDownLatch(1);
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            }, "Thread one");

            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            }, "Thread two");
            one.start();
            two.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "The " + i + " times: (" + x + ", " + y + ")";
            if (x == 1 && y == 1) {

                System.out.println(result);
                break;
            } else {
                System.out.println(result);

            }
        }
    }
}
