package com.catylee.thread.method;

/**
 * @author yangbo
 * @date
 */
public class Synchronized {
    public int count=0;
    public final Object o=new Object();
    public synchronized void n() throws InterruptedException {
            for (int i = 0; i < 100; i++) {
                count++;
                Thread.sleep(20);
                System.out.println(Thread.currentThread().getName()+"执行代码++"+count);
            }
    }

    static public class T1 extends Thread{
        Synchronized aSynchronized;
        public T1(Synchronized aSynchronized){
            this.aSynchronized=aSynchronized;
        }
        @Override
        public void run() {

            try {
                aSynchronized.n();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static public class T2 extends Thread{
        Synchronized aSynchronized;
        public T2(Synchronized aSynchronized){
            this.aSynchronized=aSynchronized;
        }
        @Override
        public void run() {

            try {
                aSynchronized.n();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Synchronized s=new Synchronized();
        T1 t1=new T1(s);
        T2 t2=new T2(s);
        t1.start();
        t2.start();

    }
}
