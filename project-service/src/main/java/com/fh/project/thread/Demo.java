package com.fh.project.thread;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();

       new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a开始执行");
                System.out.println("a....");
                System.out.println("a执行完毕");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("b开始执行");
                System.out.println("b....");
                System.out.println("b执行完毕");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("c开始执行");
                System.out.println("c....");
                System.out.println("c执行完毕");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("d开始执行");
                System.out.println("d....");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("d执行完毕");
            }
        }).start();

        // 只有主线程的时候，说明其他线程执行完毕了
        // 一直占用时间片，不往下执行
        while (Thread.activeCount() !=1 ){
            // 自旋锁
        }
        System.out.println("所有线程执行完毕");

    }
}
