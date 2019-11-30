package com.fh.project.algo.sort;

/**
 * 冒泡排序：把相邻的两个数进行比较，看是否满足大小要求，如果不满足就互换
 * 每进行一次冒泡操作后，总会有一个元素在它应该在的位置
 * 重复n-1次操作
 * 优化：
 * 判断在一次冒泡中是否有数据交换，如果没有，就证明已经是有序的数组，那么就可以直接退出循环
 */
public class BubbleSort {

    public static void main(String[] args) {


        int[] ints = new int[]{6, 5, 4, 3, 2, 1};
        sort3(ints, 6);
        //sort(ints);
    }


    public static void sort(int[] data, int length) {

        for (int i = 0; i < length; ++i) {

            boolean flag = false;
            for (int j = 0; j < length - i - 1; ++j) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }


    public static void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // 交换
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }

        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    public static void sort2(int[] data, int n) {
        if (n <= 1)
            return;
        for (int i = 0; i < n - 1; ++i) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }

        }
        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    /**
     * 冒泡排序：相邻的两元素进行比较，一轮冒泡之后，有一个数据会到它应该在的位置
     * 几轮之后，后面的元素都是有序的，就不应该再排序了
     * 优化：每一轮冒泡比较，如果没有元素的交换，说明已经是有序的了，可以直接返回
     */
    public static void sort3(int[] data, int n) {
        if (n <= 1)
            return;

        for (int i = 0; i < n -1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j + 1] < data[j]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }
}
