package com.fh.project.algo.sort;

public class MergeSort2 {

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
        merge(nums, start, center, end);

    }

    private static void merge(int[] nums, int start, int center, int end) {

        int i = start;
        int j = center + 1;
        int tempIndex = 0;
        int[] temp = new int[end - start + 1];
        while (i <= center && j <= end) {
            if (nums[i] < nums[j]) {
                temp[tempIndex++] = nums[i++];
            } else {
                temp[tempIndex++] = nums[j++];
            }
        }

        // 判断左右两个数据，哪个数组还有元素
        if (i <= center) {
            while (i <= center) {
                temp[tempIndex++] = nums[i++];
            }
        } else {
            while (j <= end) {
                temp[tempIndex++] = nums[j++];
            }
        }

        // 把临时数组赋值给原数组
        for (int p = 0; p < tempIndex; p++) {
            nums[start + p] = temp[p];
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
        MergeSort2.mergeSort(nums, nums.length);
        MergeSort2.printAll(nums);

    }
}
