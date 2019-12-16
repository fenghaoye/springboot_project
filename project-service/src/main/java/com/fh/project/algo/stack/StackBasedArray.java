package com.fh.project.algo.stack;

/**
 * 使用数组实现的顺序栈
 */
public class StackBasedArray<T> {

    private T[] elements;
    private int capacity;
    private int length;

    public StackBasedArray(int capacity) {
        this.capacity = capacity;
        length = 0;
        elements = (T[]) new Object[capacity];

    }

    // 出栈
    public T pop() {
        if (length == 0) {
            return null;
        }
        T element = elements[length - 1];
        length--;
        return element;
    }

    // 入栈
    public boolean push(T t) {
        if (length == capacity) {
            System.out.println("该栈已经满，请先出栈再入栈");
            return false;
        }
        elements[length] = t;
        length++;
        return true;
    }
}
