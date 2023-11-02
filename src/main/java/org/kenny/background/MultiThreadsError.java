package org.kenny.background;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * First: Error in running results.
 * Demonstrate that the count is inaccurate (reduced)
 * and find out exactly where it went wrong.
 */
public class MultiThreadsError implements Runnable {
    int index = 0;
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();
    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(4);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(4);
    final boolean[] marked = new boolean[1000000];
    static final MultiThreadsError instance = new MultiThreadsError();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        Thread thread3 = new Thread(instance);
        Thread thread4 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join(); // let main thread wait for child threads finishing before running
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println("outcome: " + instance.index);
        System.out.println("actual running times: " + realIndex.get());
        System.out.println("error running times: " + wrongCount.get());
    }

    @Override
    public void run() {
        marked[0] = true;
//     while (index < 10000) {
//        index++;
//     }
        for (int i = 0; i < 10000; i++) {
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await(); // 2 threads arrived and released
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            realIndex.incrementAndGet();
            synchronized (instance) {
                if (marked[index] && marked[index - 1]) {
//                if (marked[index]) {
                    System.out.println(Thread.currentThread().getName() + " make the error. Error existed: " + index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }

        }
    }
}
