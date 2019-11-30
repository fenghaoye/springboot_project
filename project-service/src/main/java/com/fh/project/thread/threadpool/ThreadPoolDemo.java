package com.fh.project.thread.threadpool;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ThreadPoolDemo {

    ExecutorService executor = Executors.newFixedThreadPool(5);

    public void test() {
        List<Future<Integer>> taskList = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            ThreadPoolDemoTask task = new ThreadPoolDemoTask();
            Future<Integer> submit = executor.submit(task);
            System.out.println("添加:" + i);
            taskList.add(submit);
        }

        executor.shutdown();
    }


    public static void main(String[] args) {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.test();
        System.out.println("全部完成");

    }

}
