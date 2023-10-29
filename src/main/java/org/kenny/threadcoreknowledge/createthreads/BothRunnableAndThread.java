package org.kenny.threadcoreknowledge.createthreads;

public class BothRunnableAndThread {
    public static void main(String[] args) {
         new Thread(new Runnable() {

             public void run() {
                 System.out.println("Come from Runnable");
             }
         }) {
             @Override
             public void run() {
                 System.out.println("Come from Thread");
             }
         }.start();
    }
}
