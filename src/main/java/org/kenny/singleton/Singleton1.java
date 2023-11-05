package org.kenny.singleton;

/**
 * Description: Eager (static constant) (ok to use)
 * Singleton related course content refer to Programmer 001 "Comparison of eight ways to write the Single Example Pattern": https://www.cnblogs.com/zhaoyan001/p/6365064.html
 * Little BMW's Dad - Dream Home "Single Example Pattern (Singleton)": https://www.cnblogs.com/BoyXiao/archive/2010/05/07/1729376.html
 * Jark's Blog "How to write the Singleton pattern correctly": http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * Hollis Chuang, "Why I recommend using enums for singletons": https://www.hollischuang.com/archives/2498
 * Hollis Chuang "Deep Analysis of Java's Enumeration Types - Thread Safety and Serialisation Issues with Enumerations": https://www.hollischuang.com/archives/197
 */
public class Singleton1 {
   private final static Singleton1 INSTANCE = new Singleton1();

   private Singleton1() {

   }

   public static Singleton1 getInstance() {
      return INSTANCE;
   }

}
