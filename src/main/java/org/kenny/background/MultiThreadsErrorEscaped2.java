package org.kenny.background;

import javax.swing.plaf.TableUI;
import java.util.concurrent.TimeUnit;

/**
 * Assigning "this" before initialisation is completed
 */
public class MultiThreadsErrorEscaped2 {
    static Point point;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PointMaker()).start();
        TimeUnit.MILLISECONDS.sleep(10);
        if (point != null) {
            System.out.println(point);
        }
    }
}

class Point {
    private final int x, y;

    public Point(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadsErrorEscaped2.point = this;
        TimeUnit.MILLISECONDS.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class PointMaker implements Runnable {

    @Override
    public void run() {
        try {
            new Point(1, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

