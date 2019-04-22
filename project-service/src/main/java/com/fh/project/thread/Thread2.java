package com.fh.project.thread;

/**
     * @discription 实现Runnable接口,作为线程的任务
     * @author FH
     * @created 23:11 2019/1/8
     * @Param
     * @return
     */
public class Thread2 implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("runable");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread2());
        thread.start();
    }
}
