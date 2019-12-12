package com.fh.project.algo.linkedlist;

import com.fh.project.basic.staticDemo.B;

import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 * @author hoda
 * @create 2018-12-17
 */
public class PalindromeLinkedList<T> {

    private SNode head;

    public PalindromeLinkedList(String str) {
        // todo 初始化链表
        String[] split = str.split("");
        SNode tail = null;
        for (String s : split) {
            SNode<String> temp = new SNode<>(s, null);
            if (head == null) {
                head = temp;
                tail = temp;
            }
            head.next = temp;
        }
    }

    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    // 使用快慢指针获取中间节点
    private SNode getCenterNode(SNode node) {
        SNode center = null;
        SNode slow = new SNode(null, node);
        SNode fast = new SNode(null, node);
        if (node.next.next == null) {
            return node.next;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null) {
            center = slow;
        } else {
            center = slow.next;
        }
        return center;

    }

    // TODO 链表反转
    private SNode revert(SNode node) {
        // 逆序center
        while (node.next != null) {
            SNode temp = node.next;
            SNode next = node.next;
            node.next = null;
            next.next = node;
            node = temp;
        }
        return node;
    }

    private void printAll() {
        SNode node = head;
        while (node != null) {
            System.out.print(node.element + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "m2on";
        PalindromeLinkedList list = new PalindromeLinkedList(str);
        list.printAll();
    }

}