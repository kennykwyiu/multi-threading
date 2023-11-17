package org.kenny.hm_thread_demo.a07threadmethod4;


public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();


        t1.setName("Plane");
        t2.setName("Tank");

        t1.start();
        t2.start();
    }
}
