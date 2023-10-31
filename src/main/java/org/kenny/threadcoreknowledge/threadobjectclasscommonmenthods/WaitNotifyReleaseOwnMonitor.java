package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * Prove that wait only releases the current lock.
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("Thread A got resourceA lock");
                    synchronized (resourceB) {
                        System.out.println("Thread A got resourceB lock");
                        try {
                            System.out.println("Thread A release resourceA lock");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("Thread B got resourceA lock.");
                    System.out.println("Thread B tries to got resourceB lock.");
                    synchronized (resourceB) {
                        System.out.println("Thread B got resourceB lock.");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
