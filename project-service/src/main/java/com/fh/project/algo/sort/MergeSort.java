package com.fh.project.algo.sort;

public class MergeSort {

    public static void mergeSort(int[] nums, int n) {
        mergeSortC(nums, 0, n - 1);
    }

    private static void mergeSortC(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int center = (start + end) / 2;
        mergeSortC(nums, start, center);
        mergeSortC(nums, center + 1, end);
        // 合并
        merge(nums, start, center, end);
    }

    private static void merge(int[] nums, int start, int center, int end) {
        int tempIndex = 0;
        int i = start;
        int j = center + 1;
        int[] temp = new int[end - start + 1]; // 初始化start到end的长度的数组
        while (i <= center && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[tempIndex++] = nums[i++];
            } else {
                temp[tempIndex++] = nums[j++];
            }
        }

        // 判断哪个数组还有剩余
        if (i <= center) {
            while (i <= center) {
                temp[tempIndex++] = nums[i++];
            }
        } else {
            while (j <= end) {
                temp[tempIndex++] = nums[j++];
            }
        }
        // 把临时变量赋值给nums
        for (int x = 0; x < end - start + 1; x++) {
            nums[start + x] = temp[x];
        }
    }

    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 2, 8, 6, 2, 5, 8, 0};
        MergeSort.mergeSort(nums, nums.length);
        SelectSort.printAll(nums);

    }

}
