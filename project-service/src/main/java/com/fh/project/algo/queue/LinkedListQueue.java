package com.fh.project.algo.queue;

/**
 * 基于链表实现的有界队列
 *
 * @param <T>
 */
public class LinkedListQueue<T> {

    // 链表容量
    private int capacity = 5;
    // 链表大小
    private int n;
    // 队头结点
    private Node head;
    // 队尾结点,最后一个有值的节点
    private Node tail;

    public boolean enqueue(T t) {
        // capacity == n 表示队列已满
        if (capacity == n) {
            return false;
        }
        Node node = new Node(t, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        n++;
        return true;
    }


    public T dequeue() {
        // n == 0 表示队列为空
        if (n == 0) {
            return null;
        }
        // 获取队头数据
        T temp = head.t;
        head = head.next;
        n--;
        return temp;
    }

    public void printAll(Node head) {
        while (head != null) {
            System.out.print(head.t + ",");
            head = head.next;
        }
        System.out.println();
    }

    public class Node {
        T t;
        Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.printAll(queue.head);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.printAll(queue.head);
        queue.dequeue();
        queue.printAll(queue.head);
    }
}
