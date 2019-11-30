package com.fh.project.thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemoTask implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName()+"执行完成");
        return 1;
    }
}
