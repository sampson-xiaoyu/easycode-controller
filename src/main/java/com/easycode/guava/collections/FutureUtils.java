package com.easycode.guava.collections;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureUtils {

    public static void main(String arg[])
    {

        //normal();

        //future();

        listenableFuture();
    }

    public static void listenableFuture(){
        ListenableFutureTask<Boolean> futureTask1 = ListenableFutureTask.create(new Callable<Boolean>() {
            public Boolean call(){
                try {
                    Thread.sleep(2000);
                    System.out.println("买菜");
                }catch (Exception e){
                    System.out.println("买菜出问题了");
                }
                return true;
            }
        });
        Thread thread1 = new Thread(futureTask1);

        ListenableFutureTask<Boolean> futureTask2 = ListenableFutureTask.create(new Callable<Boolean>() {
            public Boolean call(){
                try {
                    Thread.sleep(1000);
                    System.out.println("做饭");
                }catch (Exception e){
                    System.out.println("做饭出问题了");
                }
                return true;
            }
        });
        Thread thread2 = new Thread(futureTask2);

        try {
            thread1.start();
            thread2.start();

            futureTask1.addListener(new Runnable() {
                public void run() {
                    System.out.println("菜买好了");
                }
            }, MoreExecutors.directExecutor());

            futureTask2.addListener(new Runnable() {
                public void run() {
                    System.out.println("饭做好了");
                }
            }, MoreExecutors.directExecutor());

            futureTask1.get();
            futureTask2.get();
            System.out.println("吃饭");
        }catch (Exception e){
            System.out.println("出问题了");
        }
    }

    public static void future(){

        FutureTask<Boolean> futureTask1 = new FutureTask<Boolean>(new Callable<Boolean>() {
            public Boolean call(){
                try {
                    Thread.sleep(2000);
                    System.out.println("买菜");
                }catch (Exception e){
                    System.out.println("买菜出问题了");
                }
                return true;
            }
        });
        Thread thread1 = new Thread(futureTask1);

        FutureTask<Boolean> futureTask2 = new FutureTask<Boolean>(new Callable<Boolean>() {
            public Boolean call(){
                try {
                    Thread.sleep(2000);
                    System.out.println("做饭");
                }catch (Exception e){
                    System.out.println("做饭出问题了");
                }
                return true;
            }
        });
        Thread thread2 = new Thread(futureTask2);

        try {
            thread1.start();
            thread2.start();
            futureTask1.get();
            futureTask2.get();
            System.out.println("吃饭");
        }catch (Exception e){
            System.out.println("出问题了");
        }
    }

    public static void normal(){

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("买菜");
                }catch (Exception e){
                    System.out.println("买菜出问题了");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("做饭");
                }catch (Exception e){
                    System.out.println("做饭出问题了");
                }
            }
        });

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            System.out.println("吃饭");
        }catch (Exception e){
            System.out.println("出问题了");
        }
    }
}
