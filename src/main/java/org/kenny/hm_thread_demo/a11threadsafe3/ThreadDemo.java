package org.kenny.hm_thread_demo.a11threadsafe3;

public class ThreadDemo {
    public static void main(String[] args) {
       /*
         Design a program to manage ticket sales at a cinema with 100 available tickets and three ticket selling windows.
         syn block -> syn method, it's easy to transform
        */
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "Window 1");
        Thread t2 = new Thread(myRunnable, "Window 2");
        Thread t3 = new Thread(myRunnable, "Window 3");

        t1.start();
        t2.start();
        t3.start();

    }
}
