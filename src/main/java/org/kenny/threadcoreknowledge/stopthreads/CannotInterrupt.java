package org.kenny.threadcoreknowledge.stopthreads;

public class CannotInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000
            && !Thread.currentThread().isInterrupted()) {
                if (num%100==0) {
                    System.out.println(num + " is a multiplier of 100");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
