package org.kenny.hm_thread_demo.a03threadcase3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
                        /*
        3rd method for starting multi-threading
         */

        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        Thread t1 = new Thread(futureTask);

        t1.start();

       Integer result = futureTask.get();
        System.out.println(result);
    }
}
