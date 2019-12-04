package com.fh.project.thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemoTask implements Callable<Integer> {

    private CountDownLatch countDownLatch;

    public ThreadPoolDemoTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+"执行完成");
        countDownLatch.countDown();
        return 1;
    }
}
