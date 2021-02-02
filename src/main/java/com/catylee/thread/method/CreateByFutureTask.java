package com.catylee.thread.method;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateByFutureTask {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName()+"running");
            Thread.sleep(100000);

            return 100;
        });

        Thread thread=new Thread(futureTask,"futureTask");
        thread.start();
        System.out.println("获取返回"+futureTask.get());

    }
}
