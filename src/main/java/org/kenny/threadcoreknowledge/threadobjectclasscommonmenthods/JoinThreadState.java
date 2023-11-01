package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

import java.util.concurrent.TimeUnit;

/**
 * join then mainThread.getState()
 * Comparison of state before and after thread joins via debugger
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(mainThread.getName() + "'s status : " + mainThread.getState());
                    System.out.println("End of Thread 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 1");
        thread1.start();
        System.out.println("Waiting for thread 1 finishing");
        thread1.join();
        System.out.println("Thread 1 was finished");

    }
}

/*
Waiting for thread 1 finishing
main's status : WAITING
End of Thread 1
Thread 1 was finished
 */
