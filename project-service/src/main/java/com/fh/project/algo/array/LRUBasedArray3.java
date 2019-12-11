package com.fh.project.algo.array;

import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray3<E> {

    // 定义数组的初始长度的默认值为8
    private static final int DEFAULT_CAPACITY = (1 << 3);

    // 定义数组长度
    private int length;

    // 定义数组中元素的个数
    private int count;

    // 定义数组对象
    private Object[] elements;

    // 定义一个map，用来判断数组中是否有某个key，根据key获取value，value是元素在数组对象中的下标
    private Map<Object, Integer> holder;

    // 空构造方法
    public LRUBasedArray3() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray3(int capacity) {
        length = capacity;
        elements = new Object[capacity];
        holder = new HashMap<>(capacity);
        count = 0;
    }

    public void offer(E object) {
        // 判断object是否已经存在
        Integer index = holder.get(object);
        if (index == null) { // 为空说明不存在
            if (isFull()) { // 判断数组是否已经存满
                // 已经存满，需要先移除最后一个元素，再把所有元素右移一位
                removeAndCache(object);
            } else {
                // 未存满，可以直接新增，把所有元素右移一位,新增元素index为0
                cache(object);
            }
        } else {
            // 已经存在，获取该元素的index，把index左边的所有元素往右移
            update(index);
        }


    }

    private void removeAndCache(E object) {
        // 注意这里使用--count,而不是count--
        Object element = elements[--count];
        holder.remove(element);
        cache(object);
    }

    private void cache(E object) {
        rightMove(count);
        elements[0] = object;
        holder.put(object, 0);
        count++;
    }

    private void rightMove(int end) {
        for (int i = end - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
            holder.put(elements[i], i + 1);
        }
    }

    private void update(int index) {
        Object element = elements[index];
        rightMove(index);
        elements[0] = element;
        holder.put(element, 0);
    }

    private boolean isFull() {
        return length == count;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(elements[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            //testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray3<Integer> lru = new LRUBasedArray3<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray3<Integer> lru = new LRUBasedArray3<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }

}
