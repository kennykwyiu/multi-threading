package org.kenny.hm_thread_demo.a05threadmethod2;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
