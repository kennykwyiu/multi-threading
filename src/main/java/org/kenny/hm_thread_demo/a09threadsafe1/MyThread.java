package org.kenny.hm_thread_demo.a09threadsafe1;

public class MyThread extends Thread {

    static int ticket = 0;

//   static final Object obj = new Object();

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (ticket < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + "selling " + ticket + "ticket!!!");
                } else {
                    break;
                }
            }
        }
    }
}
