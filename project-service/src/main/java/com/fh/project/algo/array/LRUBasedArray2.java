package com.fh.project.algo.array;

import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray2<E> {

    // 定义数组的初始长度的默认值
    private static final int DEFAULT_CAPACITY = (1 << 3);

    // 定义数组长度
    private int length;

    // 定义数组中元素的个数
    private int count;

    // 定义数组对象
    private Object[] elements;

    // 定义一个map，用来判断数组中是否有某个key，value为查询的次数
    private Map<Object, Integer> holder;

    // 空构造方法
    public LRUBasedArray2() {
        this(DEFAULT_CAPACITY);
    }


    public LRUBasedArray2(int capacity) {
        if (capacity > 1) {
            length = capacity;
            count = 0;
            elements = new Object[length];
            holder = new HashMap<>(length);
        } else {
            throw new IllegalArgumentException("初始化长度不能小于1");
        }
    }

    public void offer(E object) {
        // 判断数组中是否有该值
        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object);
            }
        } else {
            // 更新元素位置
            update(index);
        }

    }

    /**
     * 判断数组是否已满
     *
     * @return
     */
    private boolean isFull() {
        return count == length;
    }

    /**
     * 数组已满的情况
     * 先remove最后一个元素再添加
     *
     * @return
     */
    private void removeAndCache(E object) {
        Object element = elements[--count];
        holder.remove(element);
        cache(object);
    }

    /**
     * 直接添加
     *
     * @return
     */
    private void cache(E object) {
        // 先把count左边的元素全部移动一位
        rightRemove(count);
        elements[0] = object;
        holder.put(object, 0);
        count++;
    }

    private void rightRemove(int end) {
        for (int i = end - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
            holder.put(elements[i], i + 1);
        }
    }

    private void update(Integer end) {
        Object target = elements[end];
        rightRemove(end);
        elements[0] = target;
        holder.put(target, 0);
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
            LRUBasedArray2<Integer> lru = new LRUBasedArray2<Integer>();
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
            LRUBasedArray2<Integer> lru = new LRUBasedArray2<Integer>(capacity);
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
