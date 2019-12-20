package com.fh.project.algo.sort;

public class BubbleSort2 {

    public static int[] bubbleSort(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
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
        int[] ints = BubbleSort2.bubbleSort(nums, nums.length);
        BubbleSort2.printAll(ints);
        System.out.println("测试");
    }
}
