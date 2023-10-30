package org.kenny.threadcoreknowledge.stopthreads;

/*
call Thread.currentThread().interrupt()
 */
public class RightWayStopThreadInProduction2 implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted, Task is end!");
                break;
            }
            reInterrupt();
            System.out.println("go: " + num);
            num++;
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduction2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
