package org.kenny.singleton;

/**
 * Description: Lazy creation (thread safety, BUT, not recommended)
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        // this is blocked, but, performance is very low
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
