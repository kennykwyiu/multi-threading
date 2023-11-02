package org.kenny.background;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *  New thread created in constructor.
 *  Idea referenced from Java Concurrency In Practice's Security Releases section
 */
public class MultiThreadsErrorConstructor {
    private Map<String, String> states;
    public MultiThreadsErrorConstructor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "Monday");
                states.put("2", "Tuesday");
                states.put("3", "Wednesday");
                states.put("4", "Thursday");
            }
        }).start();
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsErrorConstructor multiThreadsErrorConstructor = new MultiThreadsErrorConstructor();
        TimeUnit.SECONDS.sleep(1);
        Map<String, String> stringMap = multiThreadsErrorConstructor.getStates();
        System.out.println(stringMap.get("1"));
    }
}
