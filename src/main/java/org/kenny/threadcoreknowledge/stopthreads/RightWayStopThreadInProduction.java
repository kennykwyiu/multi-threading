package org.kenny.threadcoreknowledge.stopthreads;

import java.time.format.DateTimeFormatter;

public class RightWayStopThreadInProduction implements Runnable{

    @Override
    public void run() {
        int num = 0;
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go: " + num);
            try {
                throwInMethodRightWay();
            } catch (InterruptedException e) {
                // logging or interrupt
                System.out.println("logging the error");
                e.printStackTrace();
            }
            num++;
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // java.lang.InterruptedException: sleep interrupted
            // only print out, didn't stop the thread, don't use e.printStackTrace()
        }
    }
    private void throwInMethodRightWay() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduction());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
