package org.kenny.hm_thread_demo.a06threadmethod3;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            System.out.println(getName() + "@" + i);
        }
    }
}
