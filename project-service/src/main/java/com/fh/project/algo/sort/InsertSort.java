package com.fh.project.algo.sort;

public class InsertSort {

    public static void main(String[] args) {

        // 交换两个数的数据
        int a = 3;
        int b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        // System.out.println("a=" + a + ";b=" + b);
        int[] ints = new int[]{4, 5, 2, 2, 3};
        insertSort5(ints, 5);

    }


    /*
        插入排序，4, 5, 2, 2, 3
        第一步：4
        第二步：4,5
        第三步：2,4,5
        第四步：2,2,4,5
        第五步：2,2,3,4,5
        从第二个数开始，每次拿这个数与前一个数作比较，然后交换，最多只需要比较j次
        j代表已经排好序的值的个数
        两个数交换的方式：
        a = a + b;
        b = a - b;
        a = a - b;
     */
    public static void insertSort(int[] data, int n) {
        for (int i = 1; i < n; i++) { // 从下标1开始比较，因为下标0的数已经是排好序的
            for (int j = i; j > 0; j--) { // j代表已经排好序的个数
                if (data[j] < data[j - 1]) {
                    // 交换
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                } else {
                    break;
                }
            }
        }

        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    public static void insertSort2(int[] data, int n) {
        for (int i = 1; i < n; ++i) {
            for (int j = i; j > 0; --j) {
                if (data[j] < data[j - 1]) {
                    // 交换
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                } else {
                    break;
                }
            }
        }

        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }


    public static void insertSort3(int[] data, int n) {
        for (int i = 1; i < n; ++i) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    // 交换
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    public static void insertSort4(int[] data, int n) {
        for (int i = 1; i < n; ++i) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];

                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }


    /**
     * 插入排序： 分为两个区间，左边是已排区间，右边是未排区间
     * 从第一个数开始与要比较的数进行比较，并移动位置，获取要插入的index
     */
    public static void insertSort5(int[] data, int n) {

        for (int i = 1; i < n; i++) {
            int value = data[i];
            int j = i - 1;
            // 获取要插入的index
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                }else {
                    break;
                }
            }
            data[j+1] = value;

        }

        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }

}
