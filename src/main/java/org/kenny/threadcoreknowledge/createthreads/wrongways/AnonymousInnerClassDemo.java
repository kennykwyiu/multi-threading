package org.kenny.threadcoreknowledge.createthreads.wrongways;

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
