package com.catylee.thread.method;

/**
 * synchronized 加载普通方法上锁this 加载静态方法上锁类
 * 线程八锁 实验锁的不同对象
 */
public class SynchronizedTest {


    public static void main(String[] args) throws InterruptedException {
        Room room=new Room();
       Thread thread= new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                Room.ins();
            }
        },"ins");

        Thread thread1= new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                Room.sum();
            }
        },"sum");
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(room.getNumber());
    }




}


class Room{
    private static Integer number=0;

    public static synchronized void ins(){
        number--;
    }

    public static synchronized void sum(){
        number++;
    }

    public Integer getNumber() {
        return number;
    }
}