package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * Two threads alternately print parity numbers from 0 to 100 with wait and notify.
 * this is a classic interview question.
 */
public class WaitNotifyPrintOddEvenWait {
    //1. we get the lock, we print.
    //2. When we're done printing,
    // we wake up the other threads and sleep ourselves.
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadOdd = new Thread(new TurningRunner(), "Odd");
        Thread threadEven = new Thread(new TurningRunner(), "Even");
        threadOdd.start();
        threadEven.start();
    }

    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    //Print when you get the lock
                    System.out.println(Thread.currentThread().getName() + " get the lock at " + count++);

//                    if ((count % 2 == 0)) {
//                        System.out.println("Even : " + count++);
//                    } else {
//                        System.out.println("Odd : " + count++);
//                    }
                    lock.notify();
                    if (count <= 100) {
                        try {
                            // If the task is not yet finished, release the current lock and sleep.
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
