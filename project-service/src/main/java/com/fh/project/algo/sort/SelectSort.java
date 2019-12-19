package com.fh.project.algo.sort;

public class SelectSort {

    public static void selectSort(int[] nums, int n) {

        for (int i = 0; i < n - 1; i++) { // 循环次数
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) { // 未排序区间，获取最小值的index
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换最小值和index为i的元素的位置
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
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
        SelectSort.selectSort(nums, nums.length);
        SelectSort.printAll(nums);

    }
}
