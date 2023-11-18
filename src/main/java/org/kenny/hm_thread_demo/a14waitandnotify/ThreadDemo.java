package org.kenny.hm_thread_demo.a14waitandnotify;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {

        // consumer and producer need to use same arrayBlockingQueue
        // create ArrayBlockingQueue
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

//        create an instance of foodie and cook, and pass ArrayBlockingQueue into it
        Cook cook = new Cook(arrayBlockingQueue);
        Foodie foodie = new Foodie(arrayBlockingQueue);

        cook.start();
        foodie.start();

    }
}
