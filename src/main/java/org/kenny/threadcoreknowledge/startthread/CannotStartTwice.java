package org.kenny.threadcoreknowledge.startthread;

public class CannotStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start(); // Exception in thread "main" java.lang.IllegalThreadStateException: Thread is already started
    }
}
