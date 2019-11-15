package com.fh.project.algo.sort;


/*
    计数排序
 */
public class CountingSort {

    // 源数组
    int[] source = null;

    int[] result = null;
    // 源数组长度
    int sourceSize = 0;
    // 桶大小
    int bullSize = 0;
    // 初始化桶
    int[] bull = null;

    // 计数桶
    int[] addBull = null;


    public CountingSort(int[] source, int bullSize) {
        this.source = source;
        this.sourceSize = source.length;
        this.bullSize = bullSize;
        this.bull = new int[bullSize];
        this.addBull = new int[bullSize];
    }

    // 计算每个分数的个数 组成数组
    public void calCount() {
        for (int number : source) {
            int count = bull[number];
            bull[number] = count + 1;
        }
    }


    // 相加
    public void addNumber() {
        for (int i = 0; i < bullSize; i++) {
            if (i == 0) {
                addBull[0] = bull[0];
            } else {
                addBull[i] = addBull[i - 1] + bull[i];
            }
        }
    }


    // 从后往前遍历原始数组
    public void calResult() {
        result = new int[sourceSize];
        for (int i = sourceSize; i > 0; i--) {
            // 获取分数
            int number = source[i - 1];
            // 查看分数所在的数组的值
            int size = addBull[number];
            // 分数的个数就是下标
            result[size - 1] = number;
            addBull[number] = addBull[number] - 1;
        }

    }


    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static  void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] source = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        CountingSort countingSort = new CountingSort(source, 6);
        countingSort.calCount();
        countingSort.addNumber();
        countingSort.calResult();
        int[] result = countingSort.result;
        for (int count : result) {
            System.out.println(count);
        }
    }

}
