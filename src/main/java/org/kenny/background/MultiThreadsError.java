package org.kenny.background;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * First: Error in running results.
 * Demonstrate that the count is inaccurate (reduced)
 * and find out exactly where it went wrong.
 */
public class MultiThreadsError implements Runnable{
    int index = 0;
    static MultiThreadsError instance = new MultiThreadsError();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join(); // let main thread wait for child threads finishing before running
        thread1.join();
        System.out.println(instance.index);
    }
    @Override
    public void run() {
//     while (index < 10000) {
//        index++;
//     }
        for (int i = 0; i < 10000; i++) {
            index++;
        }
    }
}
