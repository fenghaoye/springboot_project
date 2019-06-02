package com.fh.project.algo.sort;

public class BubbleSort {

    public static void main(String[] args) {


        int[] ints = new int[]{4, 5, 2, 2, 3};
        sort(ints);

    }


    public static void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(data[j] > data[j+1]){
                    // 交换
                    int temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
        }

        // 输出
        for (int datum : data) {
            System.out.println(datum);
        }
    }
}
