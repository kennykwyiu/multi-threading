package org.kenny.jmm;

/**
 *
 */
public class FieldVisibility2 {
    int a = 1;
    int b = 2;
    int c = 2;
    int d = 2;

    private void change() {
        a = 3;
        b = 4;
        c = 5;
        synchronized (this) {
            d = 6;
        }
    }

    private void print() {
        int aa;
        synchronized (this) {
            aa = a;
        }
        int bb = b;
        int cc = c;
        int dd = d;

        System.out.println(Thread.currentThread().getName() + ": b = " + bb + "; a = " + aa + "; c = " + cc + "; d = " + dd);
    }

    public static void main(String[] args) {
        while (true) {


            FieldVisibility2 test = new FieldVisibility2();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
            if (test.a == 3 && test.b == 2) {
                break;
            }
        }

    }
}
