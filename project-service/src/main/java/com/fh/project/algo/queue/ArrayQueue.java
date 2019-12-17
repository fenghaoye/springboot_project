package com.fh.project.algo.queue;

/**
 * 基于数组实现的有限队列
 *
 * @param <T>
 */
public class ArrayQueue<T> {

    // 数组对象
    private T[] elements;
    // 数组大小
    private int n;
    // 队头下标
    private int head = 0;
    // 队尾下标，表示最后一个有值的元素下标+1
    private int tail = 0;

    public boolean enqueue(T t) {
        // tail == n 表示队尾没有空间了
        if (tail == n) {
            // tail == n && head == 0 表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            // 数据左移操作
            for (int i = head; i < tail; i++) {
                elements[i - head] = elements[i];
            }
            // 重新更新tail和head的下标
            tail -= head;
            head = 0;
        }
        elements[tail] = t;
        tail++;
        return true;
    }

    public T dequeue() {
        // head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        // 获取队头数据
        T temp = elements[head];
        head++;
        return temp;
    }
}
