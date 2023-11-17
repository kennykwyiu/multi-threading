package org.kenny.hm_thread_demo.a07threadmethod4;

public class MyThread extends Thread{


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            System.out.println(getName() + "@" + i);
            Thread.yield();
        }
    }
}
