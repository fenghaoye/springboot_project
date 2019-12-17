package com.fh.project.algo.queue;

/**
 * 基于链表实现的无界队列
 *
 * @param <T>
 */
public class LinkedBlockingQueue<T> {

    // 队头结点
    private Node head;
    // 队尾结点
    private Node tail;

    public boolean enqueue(T t) {
        Node node = new Node(t, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }


    public T dequeue() {
        if (head == null) {
            return null;
        }
        // 获取队头数据
        T temp = head.t;
        head = head.next;
        // 判断队列是不是只有一个元素
        if (head == null) {
            tail = null;
        }
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
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.printAll(queue.head);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(6);
        queue.enqueue(6);
        queue.printAll(queue.head);
        queue.dequeue();
        queue.printAll(queue.head);
    }
}
