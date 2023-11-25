package org.kenny.adcanced.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool OOM situation
 */
public class FixedThreadPoolOOM {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(1_000_000_000_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
