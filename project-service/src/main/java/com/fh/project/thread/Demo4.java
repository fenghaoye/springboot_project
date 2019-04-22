package com.fh.project.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo4 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("多线程方法");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws Exception{
        /*Demo4 demo4 = new Demo4();

        FutureTask<Integer> task = new FutureTask<Integer>(demo4);

        Thread  thread = new Thread(task);
        thread.start();

        System.out.println("先做点别的");
        Integer integer = task.get();
        System.out.println("查询结果"+integer);
*/
        // array 表示一个长度为 n 的数组
        // 代码中的 array.length 就等于 n
        Demo4 demo4 = new Demo4();
        demo4.insert(5);


    }

    int[] array = new int[10];
    int count = 0;
    void insert(int val) {
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }

        array[count] = val;
        ++count;
    }
}
