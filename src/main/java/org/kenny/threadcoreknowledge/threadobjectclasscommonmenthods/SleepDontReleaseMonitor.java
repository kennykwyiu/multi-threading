package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * Demonstrate that the thread does not release the synchronized monitor when it sleeps,
 * and only releases the lock when the sleep time is up and it finishes normally
 */
public class SleepDontReleaseMonitor implements Runnable{
    public static void main(String[] args) {
         SleepDontReleaseMonitor sleepDontReleaseMonitor = new SleepDontReleaseMonitor();
        Thread one = new Thread(sleepDontReleaseMonitor);
        Thread two = new Thread(sleepDontReleaseMonitor);
        one.start();
        two.start();

    }
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println("Thread " + Thread.currentThread().getName() + " got the monitor.");
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " went out from the synchronized block.");

    }
}
