package org.kenny.hm_thread_demo.a06threadmethod3;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {

            System.out.println(getName() + "@" + i);
        }
    }
}
