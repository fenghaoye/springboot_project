package com.fh.project.thread.threadpool;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ThreadPoolDemo {

    ExecutorService executor = Executors.newFixedThreadPool(5);

    public void test() {
        List<Future<Integer>> taskList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(50);

        for (int i = 0; i < 50; i++) {
            ThreadPoolDemoTask task = new ThreadPoolDemoTask(countDownLatch);
            Future<Integer> submit = executor.submit(task);
            System.out.println("添加:" + i);
            taskList.add(submit);

        }

        try {
            // 主线程阻塞，等task都执行完才会往下走
            countDownLatch.await();
            System.out.println("countDownLatch.await执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭了不再接收新的任务
        executor.shutdown();
    }


    public static void main(String[] args) {
        // 初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        // 查询的数据
        List<String> listStr = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(listStr.size());

        // 返回的数据
        List<String> result = Collections.synchronizedList(new ArrayList<>());
        for (String str : listStr) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    // 处理数据
                    try {
                        result.add(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // 计数器每次-1
                        countDownLatch.countDown();
                    }

                }
            });
        }

        try {
            // 线程阻塞，直到中断，或者计数器的值为0
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
