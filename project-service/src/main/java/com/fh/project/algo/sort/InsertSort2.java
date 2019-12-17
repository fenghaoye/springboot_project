package com.fh.project.algo.sort;

public class InsertSort2 {

    public static int[] insertSort(int[] nums, int n) {

        for (int i = 1; i < n; i++) { // 未排区间
            int num = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) { // 已排区间,有序
                if (nums[j] > num) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }

            nums[j + 1] = num;
        }
        return nums;
    }

    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 2, 8, 6};
        int[] ints = InsertSort2.insertSort(nums, nums.length);
        InsertSort2.printAll(ints);

    }
}
