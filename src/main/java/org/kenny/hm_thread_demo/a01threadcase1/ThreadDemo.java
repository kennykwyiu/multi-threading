package org.kenny.hm_thread_demo.a01threadcase1;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        1st method for starting multi-threading
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread#1");
        t2.setName("Thread#2");

        t1.start();
        t2.start();
    }
}
