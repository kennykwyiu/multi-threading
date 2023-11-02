package org.kenny.background;

import java.util.concurrent.TimeUnit;

public class MultiThreadsErrorObserverPattern {
    int count;

    public MultiThreadsErrorObserverPattern(MySource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println("\nI got the number: " + count);
            }
        });

        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mySource.eventCome(new Event() {
                });
            }
        }).start();

        MultiThreadsErrorObserverPattern multiThreadsErrorObserverPattern = new MultiThreadsErrorObserverPattern(mySource);
    }

    static class MySource {


        private EventListener listener;

        void registerListener(EventListener eventListener) {
            this.listener = eventListener;
        }

        void eventCome(Event event) {
            if (listener != null) {
                listener.onEvent(event);
            } else {
                System.out.println("still not finished initialization");
            }
        }
    }

    interface EventListener {
        void onEvent(Event event);
    }

    interface Event {

    }
}
