package org.kenny.hm_thread_demo.a13waitandnotify;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread cookThread = new Thread(new Cook("Cook"));
        Thread foodieThread = new Thread(new Foodie("Foodie"));

        cookThread.start();
        foodieThread.start();
    }
}
