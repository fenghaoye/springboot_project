package com.fh.project.algo.linkedlist;

import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 * @author hoda
 * @create 2018-12-17
 */
public class LRUBaseLinkedList2<T> {

    private static final Integer DEFAULT_CAPACITY = 10;

    // 链表长度
    private Integer length;

    // 链表容量
    private Integer capacity;

    // 头结点
    private Node head;

    public LRUBaseLinkedList2() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList2(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = new Node();
    }

    class Node<T> {
        T t;
        Node next;

        public Node() {
        }

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(T t) {
        // 1、判断元素是否存在
        Node preNode = findPreNode(t);
        // 2、不存在，判断容量是否已满，新增到链表
        if (preNode == null) {
            if (length == capacity) {
                // 删除尾部链表，新增头部链表
                deleteListEnd();
                insetListAtHead(t);
            } else {
                // 新增头部链表
                insetListAtHead(t);
            }
        } else {
            // 3、存在，移除该位置的元素，增加到链表头部
            remove(preNode);
        }
    }

    private void remove(Node preNode) {
        Node node = preNode.next;
        preNode.next = node.next;
        head.next = new Node(node.t, head.next);
    }

    private void insetListAtHead(T t) {
        Node node = head;
        Node temp = new Node(t, node.next);
        node.next = temp;
        length++;
    }

    private void deleteListEnd() {
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

    private Node findPreNode(T t) {
        Node node = head;
        while (node.next != null) {
            if (node.next.t.equals(t)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void printAll() {
        LRUBaseLinkedList2.Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getT() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList2 list = new LRUBaseLinkedList2(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}