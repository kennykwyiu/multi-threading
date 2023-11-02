package org.kenny.background;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布(Publishing)
 * 逸出(Escaped)
 */
public class MultiThreadsErrorEscapedImproved {
    private Map<String, String> states;
    public MultiThreadsErrorEscapedImproved() {
        states = new HashMap<>();
        states.put("1", "Monday");
        states.put("2", "Tuesday");
        states.put("3", "Wednesday");
        states.put("4", "Thursday");
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsErrorEscapedImproved multiThreadsErrorEscaped = new MultiThreadsErrorEscapedImproved();
        Map<String, String> escapedStates = multiThreadsErrorEscaped.getStatesImproved();
        System.out.println(escapedStates.get("1"));
        escapedStates.remove("1");
        System.out.println(escapedStates.get("1"));
        System.out.println(multiThreadsErrorEscaped.getStatesImproved().get("1"));
    }
}
