package org.kenny.background;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布(Publishing)
 * 逸出(Escaped)
 */
public class MultiThreadsErrorEscaped {
    private Map<String, String> states;
    public MultiThreadsErrorEscaped() {
        states = new HashMap<>();
        states.put("1", "Monday");
        states.put("2", "Tuesday");
        states.put("3", "Wednesday");
        states.put("4", "Thursday");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsErrorEscaped multiThreadsErrorEscaped = new MultiThreadsErrorEscaped();
        Map<String, String> escapedStates = multiThreadsErrorEscaped.getStates();
        System.out.println(escapedStates.get("1"));
        escapedStates.remove("1");
        System.out.println(escapedStates.get("1"));
    }
}
