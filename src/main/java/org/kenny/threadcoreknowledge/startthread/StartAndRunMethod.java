package org.kenny.threadcoreknowledge.startthread;

public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run(); // main

        new Thread(runnable).start(); // Thread-0
    }
}
