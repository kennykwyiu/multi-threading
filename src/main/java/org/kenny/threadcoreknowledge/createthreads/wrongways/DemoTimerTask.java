package org.kenny.threadcoreknowledge.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

public class DemoTimerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        final int count = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
