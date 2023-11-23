package org.kenny.concurrency_tools.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Use Lock to Solve Thread Safety Problems
 */
public class ThreadLocalNormalUsage04 {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage04().date(finalI);
                    System.out.println(date);
                }
            };
            threadPool.execute(runnable);
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {

        // Parameters are in milliseconds and are timed from 1970.1.1 00:00:00 GMT.
        Date date = new Date(1000 * seconds);
        String format;
        synchronized (ThreadLocalNormalUsage04.class) {
            format = dateFormat.format(date);
        }
        return format;
    }
}
