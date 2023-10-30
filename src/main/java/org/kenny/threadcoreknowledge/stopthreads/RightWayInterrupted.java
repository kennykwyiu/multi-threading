package org.kenny.threadcoreknowledge.stopthreads;

/**
 * Note that the target of the Thread.interrupted() method is the "current thread",
 * regardless of the object from which the method is derived.
 *
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // Starting a thread
        threadOne.start();
        //Setting the interrupt flag
        threadOne.interrupt();
        //Get interrupt flag
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); //return interrupted;
        //Get interrupt flag and reset
        System.out.println("isInterrupted: " + threadOne.interrupted()); //return currentThread().getAndClearInterrupt(); -> return oldValue;
        //Get interrupt flag and reset
        System.out.println("isInterrupted: " + Thread.interrupted()); //return currentThread().getAndClearInterrupt(); -> return oldValue;
        //Get interrupt flag
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); // return interrupted;


        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
