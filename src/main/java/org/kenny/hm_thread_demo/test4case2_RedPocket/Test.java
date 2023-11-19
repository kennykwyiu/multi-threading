package org.kenny.hm_thread_demo.test4case2_RedPocket;


public class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t4.setName("D");
        t5.setName("E");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
}
