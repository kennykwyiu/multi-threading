package org.kenny.hm_thread_demo.a02threadcase2;

public class MyRun implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "HelloWorld");
        }
    }
}
