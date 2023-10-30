package org.kenny.threadcoreknowledge.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Demonstrate the limitations of using volatile part2 Volatile cannot stop a thread when it gets blocked.
 * In this example, the producer is producing very fast and the consumer is consuming slowly,
 * so when the blocking queue is full, the producer will block and wait for the consumer to consume more.
 */
public class WrongWayVolatileCannotStop {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + " was consumed");
            Thread.sleep(100);
        }
        System.out.println("Consumer don't need any more data");
        producer.canceled = true;
        System.out.println(producer.canceled);
    }

}

class Producer implements Runnable {
    public volatile boolean canceled = false;

    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !canceled) {
                if (num % 100 == 0) {
                    storage.put(num);
                    System.out.println(num + " is a multiplier of 100, and put into storage");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Producer is stopped");
        }
    }
}

class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }
}