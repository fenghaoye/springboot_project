package com.fh.project.thread;

/**
     * @discription 继承Thread类，重写run方法
     * @author FH
     * @created 23:17 2019/1/8
     * @Param
     * @return
     */
public class Thread1 extends Thread {

    @Override
    public void run() {
        // 重写run方法
        System.out.println("extends Thread");
    }

    public static void main(String[] args) {
        Thread1 thread = new Thread1();
        thread.start();
    }
}
