package com.fh.project.thread;

/**
     * @discription 匿名内部类
     * @author FH
     * @created 23:14 2019/1/8
     * @Param
     * @return
     */
public class Thread3 {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("sub thread");
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable接口");
            }
        });

        thread.start();

    }

}
