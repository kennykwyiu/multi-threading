package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

/**
 * 3 threads, thread1 and thread2 are blocked firstly.
 * thread3 wakes them up. notify, notifyAll.
 * call start() first doesn't mean the thread starts first.
 */
public class WaitNotifyAll implements Runnable{

    private static final Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitNotifyAll();
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
//                    resourceA.notify();
                    System.out.println("ThreadC notifyAll");
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(1);
        threadC.start();

    }

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + " got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName() + " waits to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName() + "'s waiting will be end shortly.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
