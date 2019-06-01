package com.fh.project.thread;

public class DeadLock {

    private Object object1 = new Object();
    private Object object2 = new Object();

    public void a(){
        synchronized (object1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println("a..");
            }
        }
    }

    public void b(){
        synchronized (object2){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){
                System.out.println("b..");
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个对象
        DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.b();
            }
        }).start();
    }
}
