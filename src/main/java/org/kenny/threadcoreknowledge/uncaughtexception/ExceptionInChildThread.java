package org.kenny.threadcoreknowledge.uncaughtexception;

/**
 * Single thread can throw, handle, if has exception in stack
 * Multi-thread, exception occurs in child thread,
 * what would be the difference?
 */
public class ExceptionInChildThread implements Runnable{
    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
