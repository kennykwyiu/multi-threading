package org.kenny.hm_thread_demo.a12deadlock;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread A");
        MyThread t2 = new MyThread("Thread B");

        t1.start();
        t2.start();
    }
}
