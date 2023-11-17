package org.kenny.hm_thread_demo.a02threadcase2;

public class ThreadDemo {
    public static void main(String[] args) {
                /*
        2nd method for starting multi-threading
         */

        MyRun myRun = new MyRun();
        Thread t1  = new Thread(myRun);
        Thread t2  = new Thread(myRun);

        t1.setName("Thread1: ");
        t2.setName("Thread2: ");

        t1.start();
        t2.start();
    }
}
