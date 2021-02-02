package com.catylee.thread.method;

/**
 * @author yangbo
 * @date
 */
public class T1 {
    private Integer value;

    public T1(Integer value) {
        this.value = value;
    }

    public synchronized Integer getNextValue(){
        return value++;
    }

    public static void main(String[] args) {
        T1 t=new T1(0);

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                System.out.println(t.getNextValue()+"-----"+Thread.currentThread().getName()+Thread.currentThread().getId());
            },i+"").start();
        }
        /*Thread thread1=new Thread(()->{
            System.out.println(t.getNextValue()+"-----"+Thread.currentThread().getName());
        },"t1");

        Thread thread2=new Thread(()->{
            System.out.println(t.getNextValue()+"-----"+Thread.currentThread().getName());
        },"t2");

        thread1.start();
        thread2.start();*/
    }

}
