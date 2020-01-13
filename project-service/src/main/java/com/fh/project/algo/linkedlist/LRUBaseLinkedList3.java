package com.fh.project.algo.linkedlist;

import java.util.Scanner;

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
            deleteNode(findNode);
            insertHead(t);
        }
    }

    // 删除某个节点
    private void deleteNode(Node deleteNode) {
        Node node = head;
        if (node.next == null) {
            return;
        }
        while (node.next != null) {
            if (node.next.t.equals(deleteNode.t)) {
                node.next = node.next.next;
                break;
            } else {
                node = node.next;
            }
        }
        length--;
    }

    private void insertHead(T t) {
        Node node = new Node(t, head.next);
        head.next = node;
        length++;
    }

    // 删除尾部节点
    private void removeTail() {
        Node node = head;
        if (node.next == null) {
            return;
        }
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
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

    private void printAll() {
        Node node = head.next;
        while (node != null) {
            System.out.print(node.t + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList3 list = new LRUBaseLinkedList3(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.offer(sc.nextInt());
            list.printAll();
        }
    }

}
