package org.kenny.threadcoreknowledge.sixstates;

/**
 * Shows the thread's NEW, RUNNABLE, and TERMINATED states.
 * Even if it is running, it is in Runnable state, not Running.
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        // Print out the status of NEW
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Prints out the status of RUNNABLE, even if it is running, instead of RUNNING
        System.out.println(thread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Print out the TERMINATED status
        System.out.println(thread.getState());

    }
}
