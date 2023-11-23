package org.kenny.concurrency_tools.threadlocal;

/**
 * Demonstrating high-coupling usage of threadLocal
 */
public class ThreadLocalWrongPractice {
    public static void main(String[] args) {
        new WrongPracticeService1().process("Kenny");
    }
}

class WrongPracticeService1 {
    public void process(String name) {
        User user = new User(name);
        UserContextHolder.holder.set(user);
        new WrongPracticeService2().process(user);
    }
}
class WrongPracticeService2 {
    public void process(User user) {
//        User user = UserContextHolder.holder.get();
        System.out.println("Service2 print out: " + user.name);
        new WrongPracticeService3().process(user);
    }
}
class WrongPracticeService3 {
    public void process(User user) {
//        User user = UserContextHolder.holder.get();
        System.out.println("Service3 print out: " + user.name);
    }
}
