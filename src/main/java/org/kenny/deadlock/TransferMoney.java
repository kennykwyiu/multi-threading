package org.kenny.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Objects;

/**
 * Deadlock when transferring money, once the comment is opened
 */
public class TransferMoney implements Runnable {
    int flag = 1;
    static Account a = new Account(500);
    static Account b = new Account(500);

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    public static void transferMoney(Account from, Account to, int amount) {
        synchronized (from) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (to) {
                if (from.balance - amount < 0) {
                    System.out.println(Thread.currentThread().getName() + " is insufficient balance, transfer failed.");
                }
                from.balance -= amount;
//                to.balance = to.balance + amount;
                to.balance += amount;
                System.out.println(Thread.currentThread().getName() + " is successful transfers " + amount + " dollars.");

            }
        }
    }

    static class Account {
        int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();

        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (!Objects.isNull(deadlockedThreads) && deadlockedThreads.length > 0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println("Find deadlock: " + threadInfo.getThreadName());
            }
        }
        thread1.join();
        thread2.join();
        System.out.println("a's balance " + a.balance);
        System.out.println("b's balance " + b.balance);
    }
}
