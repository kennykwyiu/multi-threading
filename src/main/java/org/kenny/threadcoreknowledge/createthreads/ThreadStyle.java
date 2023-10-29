package org.kenny.threadcoreknowledge.createthreads;

public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("Using Thread for creating new thread");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
