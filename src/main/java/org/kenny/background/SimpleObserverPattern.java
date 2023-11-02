package org.kenny.background;

public class SimpleObserverPattern {
    static class MySource {
        private EventListener listener;
        void registerListener(EventListener eventListener) {
           this.listener = eventListener;
        }
        void  eventCome(Event event) {
            if (listener !=null) {
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
