package org.kenny.threadcoreknowledge.createthreads;

public class RunnableStyle implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    public void run() {
        System.out.println("Using Runnable for creating thread");
    }
}
