package com.fh.project.algo.array;

/**
 * 最近最少使用策略 LRU（Least Recently Used）
 * 数组实现
 */
public class ArrayLRU {


    // 初始化一个数组
    int[] array;
    // 初始化一个n长度的数组
    int n;
    // 数组中已存的数据大小
    int length;

    public ArrayLRU(int n) {
        this.n = n;
        array = new int[n];
    }

    /**
     * int方法,末尾是最近使用的
     * 1、从数组中查找是否已有这个数据，我们获取这个数据,删除此位置的元素，插入到末尾
     * 2、没有在数组中
     * 缓存未满，直接插入到末尾
     * 缓存已满，插入到尾部
     */
    public void insert(int num) {
        for (int i = 0; i < length; i++) {
            if (num == array[i]) {
                // 删除此位置的元素，插入到末尾
                for (int y = i; y < length - 1; y++) {
                    array[y] = array[y + 1];
                }
                array[length-1] = num;
                return;
            }
        }
        if (n == length) {
            // 缓存已满
            for (int i = 0; i < length-1; i++) {
                array[i] = array[i + 1];
            }
            array[length-1] = num;
        } else {
            array[length] = num;
            length++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, 6};
        ArrayLRU arrayLRU = new ArrayLRU(3);
        arrayLRU.insert(1);
        arrayLRU.insert(2);
        arrayLRU.insert(2);
        arrayLRU.insert(3);
        arrayLRU.insert(4);
        arrayLRU.insert(2);
        arrayLRU.insert(5);
        arrayLRU.insert(6);
        arrayLRU.insert(1);
        arrayLRU.insert(2);
    }
}
