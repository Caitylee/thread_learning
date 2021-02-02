package com.catylee.thread.method;

/**
 * @author yangbo
 * @date
 */
public class SleepYieldJoin {

    static  class  MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(currentThread().getName()+"开始执行");
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        System.out.println(Thread.currentThread().getName()+"开始执行");
        myThread.setName("我的线程");
        myThread.start();
    }


    static void yield(){

    }

    static void sleep(){

    }


    static void join(){
        Thread t1=new Thread( ()->{
            for (int i=0;i<1000;i++){

        }
        });


        t1.getState();
    }
}
