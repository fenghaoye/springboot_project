package com.fh.project.algo.linkedlist;

import com.fh.project.algo.LinkedListAlgo;
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
        for (String s : split) {
            insert(s);
        }
    }

    //顺序插入
    public void insert(String s) {
        SNode newNode = new SNode(s);
        if (head == null) {
            head = newNode;
        } else {
            SNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            // 现在p已经是最后一个节点了，插入新节点到最后一个节点
            p.next = newNode;
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

    // 使用快慢指针获取中间节点
    private SNode getCenterNode2(SNode node) {
        SNode center = null;
        SNode slow = head;
        SNode fast = head;
        // 只有一个节点
        if (slow.next == null) {
            return slow;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null) {
            // slow节点一定是整个链表的中点，且节点数目为奇数
            center = slow;
        } else {
            // slow和slow.next均为链表的中点
            center = slow.next;
        }
        return center;

    }

    // 单链表反转
    public SNode reverse(SNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.getNext() == null) {
            return head;
        }

        SNode curr = head;
        SNode pre = null;
        SNode next = null;
        while (curr != null) {
            // 获取当前节点的下一个节点
            next = curr.next;
            // 设置当前节点的下一个节点为null
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    private void printAll(SNode node) {
        while (node != null) {
            System.out.print(node.element + ",");
            node = node.getNext();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str = "m2on";
        PalindromeLinkedList list = new PalindromeLinkedList(str);
        list.printAll(list.head);
        list.printAll(list.reverse(list.head));
    }

}