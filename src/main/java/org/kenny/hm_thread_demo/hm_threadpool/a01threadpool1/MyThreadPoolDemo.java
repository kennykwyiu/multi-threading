package org.kenny.hm_thread_demo.hm_threadpool.a01threadpool1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        pool1.submit(new MyRunnable());

        pool1.submit(new MyRunnable());

        pool1.submit(new MyRunnable());

        pool1.submit(new MyRunnable());

        pool1.submit(new MyRunnable());

        //        pool1.shutdown();
    }
}
