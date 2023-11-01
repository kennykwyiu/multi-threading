package org.kenny.threadcoreknowledge.uncaughtexception;

import java.util.concurrent.TimeUnit;

/**
 * 1. throws 4 exceptions without a try catch, all with thread names.
 * 2. adds a try catch, expecting to catch the first thread's exception,
 * thread 234 should not run, and expecting to see a Caught Exception printed out.
 * 3. when executing, we find that there is no Caught Exception at all,
 * but thread 234 still runs and throws an exception.
 * <p>
 * Explain that exceptions in threads cannot be caught using traditional methods
 */
public class CantCatchDirectly implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        try { // try catch only can catch the exception in the main thread
            // all exception in the child thread, cannot be caught
            new Thread(new CantCatchDirectly(), "MyThread-1").start();
            TimeUnit.MILLISECONDS.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-2").start();
            TimeUnit.MILLISECONDS.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-3").start();
            TimeUnit.MILLISECONDS.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-4").start();
        } catch (InterruptedException e) {
            System.out.println("Caught Exception");
        }
    }

    @Override
    public void run() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Caught exception");
        }
    }
}
