package com.fh.project.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton2 {

    // 私有构造方法，保证不能被外部创建
    private Singleton2(){}

    // 加上volatile  关键字
    private static volatile Singleton2 singleton ;

    /*
        对资源进行非原子性操作，这里不是线程安全的，
        需要加上 synchronized 关键字 ,虽然没有线程安全性问题发生，但是效率比较低
        双重检查加锁
     */
    public static synchronized  Singleton2 getInstance(){
        if(singleton == null){
            // 第一个线程走到这里还没创建实例，第二个线程就也已经进来这一步了，
           synchronized (Singleton2.class){
               if(singleton == null){
                   singleton = new Singleton2(); // 有可能发生指令重排序，发生线程安全性问题，使用 volatile 关键字
               }
           }
        }
        return singleton;
    }

    public static void main(String[] args) {
        // 使用线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for(int i=0;i<100;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton2.getInstance());
                }
            });
        }

        threadPool.shutdown();
    }
}
