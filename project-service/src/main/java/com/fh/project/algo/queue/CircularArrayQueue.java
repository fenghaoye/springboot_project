package com.fh.project.algo.queue;

/**
 * 基于数组实现的循环队列
 *
 * @param <T>
 */
public class CircularArrayQueue<T> {

    // 数组对象
    private T[] elements;
    // 数组大小
    private int n;
    // 队头下标
    private int head = 0;
    // 队尾下标，这个下标的位置是不存数据的
    private int tail = 0;

    public CircularArrayQueue(int capacity) {
        this.n = capacity;
        elements = (T[]) new Object[capacity];
    }

    public boolean enqueue(T t) {
        // 队列已满
        if ((tail + 1) % n == head) {
            return false;
        }
        elements[tail] = t;
       /* if (tail == n - 1) {
            tail = 0;
        } else {
            tail++;
        }*/
        tail = (tail + 1) % n;
        return true;
    }

    public T dequeue() {
        // head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        // 获取队头数据
        T temp = elements[head];
        /*if (head == n - 1) {
            head = 0;
        } else {
            head++;
        }*/
        // 可以代替上面注释的代码
        head = (head + 1) % n;
        return temp;
    }
}
