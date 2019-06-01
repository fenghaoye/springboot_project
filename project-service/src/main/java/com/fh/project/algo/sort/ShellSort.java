package com.fh.project.algo.sort;

public class ShellSort {

    public static void main(String[] args) {

        int[] ints = new int[]{4, 3, 2, 1, 3};
        insertSort(ints);
    }


    /*
        希尔排序，4, 3, 2, 1, 3
        步长： 5 / 2 = 2
        第一步：
        4,2 分组 变成 2,4，每次都做插入排序
        3,1 分组 变成 1,3
        3
        第二步：2，4，1，3，3
        步长：2 / 2 = 1
        步长为1时就是插入排序
     */
    public static void insertSort(int[] data) {

        int n = data.length;
        int step = n;
        while (step >= 1) {
            step = step / 2;
            for (int i = step; i < n; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (data[j] < data[j - step]) {
                        // 交换
                        int temp = data[j];
                        data[j] = data[j - step];
                        data[j - step] = temp;
                    } else {
                        break;
                    }
                }
            }

        }


        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }
}
