package org.kenny.hm_thread_demo.a06threadmethod3;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();


        t1.setName("MyGod");
        t2.setName("Backup");

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}
