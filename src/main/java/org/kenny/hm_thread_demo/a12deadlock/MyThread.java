package org.kenny.hm_thread_demo.a12deadlock;

public class MyThread extends Thread {
    static  Object objectA = new Object();
    static  Object objectB = new Object();

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if ("Thread A".equals(getName())) {
                synchronized (objectA) {
                    System.out.println("Thread#A get the Lock A, and going to get Lock B");
                    synchronized (objectB) {
                        System.out.println("Thread#A get the Lock B, finished a round");
                    }
                }
            } else if ("Thread B".equals(getName())) {
                if ("Thread B".equals(getName())) {
                    synchronized (objectB) {
                        System.out.println("Thread#B get the Lock B, and going to get Lock A");
                        synchronized (objectA) {
                            System.out.println("Thread#B get the Lock A, finished a round");
                        }
                    }
                }

            }
        }
    }
}
