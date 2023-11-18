package org.kenny.hm_thread_demo.a14waitandnotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put("Noodle");
                System.out.println("Cook put a bowl of noodle");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
