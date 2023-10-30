package org.kenny.threadcoreknowledge.stopthreads;

public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() &&
                num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + " is a multiple of 10,000.");
            }
            num++;
        }
        System.out.println("task running is finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
