package org.kenny.jmm;

/**
 *
 */
public class FieldVisibility {
    int a = 1;
    volatile int b = 2; // use volatile keyword, solving case of b = 3; a = 1

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {

        System.out.println("b = " + b + "; a = " + a);
    }

    public static void main(String[] args) {
        while (true) {


            FieldVisibility test = new FieldVisibility();
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
