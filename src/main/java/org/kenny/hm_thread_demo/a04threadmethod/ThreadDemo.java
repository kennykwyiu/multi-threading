package org.kenny.hm_thread_demo.a04threadmethod;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread("Plane");
    MyThread t2 = new MyThread("Tank");

    t1.start();
    t2.start();

//        Thread t = Thread.currentThread();
//       String name = t.getName();
//        System.out.println(name);

//        System.out.println("1111111111111");
//        Thread.sleep(5000);
//        System.out.println("2222222222222");
    }
}
