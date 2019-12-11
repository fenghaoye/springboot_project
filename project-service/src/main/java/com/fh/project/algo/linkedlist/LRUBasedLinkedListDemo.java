package com.fh.project.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于链表实现 LRU 缓存淘汰算法
 */
public class LRUBasedLinkedListDemo<E> {


    // 默认大小
    private static final int DEFAULT_CAPACITY = 1 << 3;

    // 链表长度
    private int length;

    // 链表实际长度
    private int count;


    private Node head;


    class Node<E> {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public LRUBasedLinkedListDemo() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedLinkedListDemo(int capacity) {
        length = capacity;
        count = 0;
    }


    public void offer(E element) {
        if (element == null) {
            throw new IllegalArgumentException("不提供null值的缓存");
        }
        if (findPreNode(element) == null) {
            if (isFull()) { // 已满,移除最后一个，新增到表头
                deleteTail();
            }
            initHeadNode(element);
        } else {
            Node preNode = findPreNode(element);
            Node next = preNode.next;
            preNode.next = next.next;
            initHeadNode(element);
        }
    }

    private void deleteTail() {
        Node next = head.next;
        if (next == null) {
            head = null;
        }
        while (next.next != null) {
            next = head.next;
        }
        next.next = null;
        count--;
    }

    // 获取查找元素的前一个节点
    private Node findPreNode(E data) {
        if (count == 1) {
            return null;
        }
        Node next = head.next;
        while (next.next != null) {
            if (next.next.element.equals(data)) {
                return next;
            }
            next = next.next;
        }
        return null;
    }

    private boolean isFull() {
        return length == count;
    }

    private void initHeadNode(E element) {
        if (count == 0) {
            head = new Node(element, null);
        } else {
            head = new Node(element, head);
        }
        count++;
    }

}
