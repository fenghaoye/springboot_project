package com.fh.project.algo.sort;

public class QuickSort {

    public static void quickSort(int[] nums, int n) {
        quickSortC(nums, 0, n - 1);
    }

    private static void quickSortC(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int q = partition(nums, start, end);
        quickSortC(nums, start, q - 1);
        quickSortC(nums, q + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int privot = nums[end]; // privot是分区点数据
        int i = start; // i把数组分成已处理区间和未处理区间，[i,end-1]是未处理区间
        for (int j = start; j <= end - 1; j++) { // 不需要嵌套循环
            if (nums[j] < privot) { // 当前元素比分区点要小，就和i的元素交换，并且i右移一位
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        // 将分区点的元素和i位置的元素互换位置
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
        return i;
    }

    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 2, 8, 6};
        QuickSort.quickSort(nums, nums.length);
        QuickSort.printAll(nums);

    }
}
