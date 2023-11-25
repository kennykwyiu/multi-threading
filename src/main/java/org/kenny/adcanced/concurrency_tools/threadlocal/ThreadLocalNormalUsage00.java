package org.kenny.adcanced.concurrency_tools.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2 threads to print the date
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(10);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(104707);
                System.out.println(date);
            }
        }).start();
    }

    public String date(int seconds) {
        // Parameters are in milliseconds and are timed from 1970.1.1 00:00:00 GMT.
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
