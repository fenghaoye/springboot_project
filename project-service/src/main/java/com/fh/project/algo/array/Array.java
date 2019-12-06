package com.fh.project.algo.array;

public class Array {

    // 测试数组的初始化，插入删除操作
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 8; i++) {
            array[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }

        String[] strs = new String[10];
        for (int i = 0; i < 8; i++) {
            strs[i] = String.valueOf(i);
        }

        strs[5] = "xxx";
        for (int i = 0; i < 10; i++) {
            System.out.println(strs[i]);
        }



    }

}
