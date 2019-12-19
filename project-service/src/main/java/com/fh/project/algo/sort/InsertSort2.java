package com.fh.project.algo.sort;

public class InsertSort2 {

    public static void insertSort(int[] nums, int n) {

        for (int i = 1; i < n; i++) { // 未排区间，下标从1开始
            int num = nums[i];
            int j = i - 1; // j为已排序区间最后一个元素的下标
            for (; j >= 0; j--) { // 已排区间,有序，从后面开始循环
                if (nums[j] > num) { // 已排区间的元素和要插入的元素进行比较
                    nums[j + 1] = nums[j]; // 右移操作
                } else {
                    break; // 跳出循环，得到j
                }
            }
            // 设置要排序元素的位置，此时index为j的元素小于num，所以应该设置index为j+1的元素为num
            nums[j + 1] = num;
        }
    }

    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 2, 8, 6};
        InsertSort2.insertSort(nums, nums.length);
        InsertSort2.printAll(nums);

    }
}
