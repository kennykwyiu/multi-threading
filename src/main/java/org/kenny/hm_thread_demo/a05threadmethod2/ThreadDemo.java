package org.kenny.hm_thread_demo.a05threadmethod2;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "PLane");
        Thread t2 = new Thread(myRunnable, "Tank");

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
        }
}
