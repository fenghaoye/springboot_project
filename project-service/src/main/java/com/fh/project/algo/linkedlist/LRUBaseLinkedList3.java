package com.fh.project.algo.linkedlist;

/**
 * 基于链表实现lru缓存淘汰算法
 */
public class LRUBaseLinkedList3<T> {


    private Integer capacity;
    private Integer length;

    private Node head;

    public LRUBaseLinkedList3(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        head = new Node();
    }

    /**
     * 最早出现的在链表尾部
     * 先从链表中获取这个元素
     * 如果存在，
     * 删除，插入链表头部
     * 如果不存在，
     * 链表已满，删除尾部，插入头部
     * 链表未满，插入头部
     */
    public void offer(T t) {
        Node findNode = getNode(t);
        if (findNode == null) {
            if (capacity == length) {
                // 删除尾部
                removeTail();
            }
            // 插入头部
            insertHead(t);
        } else {
            // 删除，插入链表头部

        }
    }

    private void deleteNode(Node node) {

    }

    private void insertHead(T t) {
        Node node = new Node(t, head.next);
        head.next = node;
        length++;
    }

    // 删除尾部
    private void removeTail() {
        Node node = head;
        if (node.next == null) {
            return;
        }
        while (node.next != null && node.next.next != null) {
            node = node.next;
        }
        node.next = node.next.next;
        length--;
    }

    // 获取某个元素
    private Node getNode(T t) {
        Node node = head.next;
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (t.equals(node.t)) {
                return node;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    class Node {
        T t;
        Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node() {

        }
    }

}
