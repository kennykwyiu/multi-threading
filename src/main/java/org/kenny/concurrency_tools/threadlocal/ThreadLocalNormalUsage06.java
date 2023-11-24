package org.kenny.concurrency_tools.threadlocal;

import java.text.SimpleDateFormat;

/**
 * Demonstrating ThreadLocal Usage 2: Avoiding the Hassle of Passing Parameters
 */
public class ThreadLocalNormalUsage06 {
    public static void main(String[] args) {
        new Service1().process("Kenny");
    }
}

class Service1 {
    public void process(String name) {
        User user = new User(name);
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {

        // here is 2 different threadLocal
        User user = UserContextHolder.holder.get();
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        System.out.println("Service2 print out: " + user.name);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3 print out: " + user.name);
        new Service4().process();
    }
}
class Service4 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service4 print out: " + user.name);
        UserContextHolder.holder.remove(); // have to remove threadLocal avoiding OOM

    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}