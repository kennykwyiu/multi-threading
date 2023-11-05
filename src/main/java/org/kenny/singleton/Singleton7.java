package org.kenny.singleton;

/**
 * Description: Static inner class (ok to use)
 */
public class Singleton7 {
    private Singleton7() {
    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
