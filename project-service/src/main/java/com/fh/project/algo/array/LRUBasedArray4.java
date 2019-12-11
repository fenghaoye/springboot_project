package com.fh.project.algo.array;


import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray4<T> {

    private static final Integer DEFAULT_CAPACITY = 1 << 3;

    private Integer length;

    private Integer count;

    private T[] objects;

    private Map<T, Integer> holder;

    public LRUBasedArray4() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray4(Integer capacity) {
        this.length = capacity;
        this.count = 0;
        objects = (T[]) new Object[capacity];
        holder = new HashMap<>();
    }

    public void offer(T t) {
        // 1、先从holder获取看存不存在
        // 2、存在就获取该值，并设置到数组头部
        // 3、不存在
        // 3.1、数组已满，移除尾部数据，并设置到数组头部，移动右边所有元素
        // 3.2、数组未满，插入到数组头部，移动右边所有元素

        Integer index = holder.get(t);
        if (index == null) {
            if (length == count) {
                removeAndCache(t);
            } else {
                cache(t, count);
            }
        } else {
            update(index);
        }


    }

    private void update(Integer end) {
        T object = objects[end];
        holder.put(object, 0);
        objects[0] = object;
        rightMove(end);
    }

    private void cache(T t, Integer end) {
        rightMove(end);
        count++;
        objects[0] = t;
        holder.put(t, 0);
    }

    private void rightMove(Integer end) {
        for (int i = end - 1; i >= 0; i--) {
            objects[i + 1] = objects[i];
            holder.put(objects[i], i + 1);
        }
    }

    private void removeAndCache(T t) {
        holder.remove(objects[--count]);
        cache(t, count);
    }
}
