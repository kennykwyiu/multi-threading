package org.kenny.hm_thread_demo.a08threadmethod5;


public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();


        t1.setName("Potato");

        t1.start();
        t1.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("main thread" + i);
        }

    }
}
