package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * The ID starts at 1. Once the JVM is up and running,
 * the IDs of the threads we create ourselves are not started from 2.
 */
public class Id {
    public static void main(String[] args) {
        Thread thread1 = new Thread();
        System.out.println("Main thread ID: " + Thread.currentThread().getId());
        System.out.println("Thread1 ID: " + thread1.getId());


    }
}
