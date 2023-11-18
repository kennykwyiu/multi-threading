package org.kenny.hm_thread_demo.a13waitandnotify;

public class Desk {

    // Zero no food, 1 has food
    // boolean only can control two threads, so, need to use int to control
    public static int foodFlag = 0;
    // Max
    public static int count = 10;
    //Lock
    public static Object lock = new Object();


}
