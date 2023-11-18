package org.kenny.hm_thread_demo.a10threadsafe2;

public class ThreadDemo {
    public static void main(String[] args) {
       /*
         Design a program to manage ticket sales at a cinema with 100 available tickets and three ticket selling windows.
         syn block -> syn method, it's easy to transform
        */
        MyThread t1 = new MyThread( "Window 1");
        MyThread t2 = new MyThread( "Window 2");
        MyThread t3 = new MyThread( "Window 3");

        t1.start();
        t2.start();
        t3.start();

    }
}
