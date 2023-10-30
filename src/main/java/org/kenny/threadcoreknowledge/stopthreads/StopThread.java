package org.kenny.threadcoreknowledge.stopthreads;

/**
 * wrong stop thread method: stop() - induce thread will be stopped
 * at running suddenly, cannot finish a basic process, cause dirty data
 *
 * 'stop()' is deprecated and marked for removal
 */
public class StopThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("team " + i + " go to get weapon");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("team " + i + " finished getting weapon");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
