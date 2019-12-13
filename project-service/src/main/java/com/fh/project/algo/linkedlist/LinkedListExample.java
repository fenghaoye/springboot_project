package com.fh.project.algo.linkedlist;

/**
 * 链表案例：
 * 单链表反转
 * 两个有序的链表合并
 * 链表中环的检测
 * 删除链表倒数第 n 个结点
 * 求链表的中间结点
 */
public class LinkedListExample<T> {

    // 单链表反转
    public Node reverse(Node node) {
        Node curr = node;
        Node pre = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    // 两个有序的链表合并，我写的
    public Node mergeTwoSortedLinkedList(Node node1, Node node2) {
        Node head = null;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 != null) {
                if ((int) node1.element <= (int) node2.element) {
                    Node temp = new Node(node1.element);
                    head = insert(head, temp);
                    node1 = node1.next;
                } else {
                    Node temp = new Node(node2.element);
                    head = insert(head, temp);
                    node2 = node2.next;
                }
            } else if (node1 != null) {
                Node temp = new Node(node1.element);
                head = insert(head, temp);
                node1 = node1.next;
            } else {
                Node temp = new Node(node2.element);
                head = insert(head, temp);
                node2 = node2.next;
            }
        }
        return head;

    }

    // // 两个有序的链表合并，案例代码
    public Node mergeTwoLists(Node l1, Node l2) {
        Node soldier = new Node(0); //利用哨兵结点简化实现难度 技巧三
        Node p = soldier;

        while (l1 != null && l2 != null) {
            if ((int) l1.element < (int) l2.element) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            // 把p往后移动一位
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }


    // 链表中 环的检测
    public boolean checkCycle(Node node) {
        if (node == null) {
            return false;
        }
        Node slow = node;
        Node fast = node;


        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 遍历插入数据到链表中
    public Node insert(int[] nums) {
        for (int number : nums) {
            Node node = new Node(number);
            if (head == null) {
                head = node;
            } else {
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = node;
            }
        }
        return head;
    }

    private Node insert(Node head, Node node) {
        if (head == null) {
            head = node;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;

        }
        return head;
    }

    private Node head;

    public class Node<T> {

        private T element;

        private Node next;

        public Node(T element) {
            this.element = element;
        }
    }


    private void printAll(Node node) {
        while (node != null) {
            System.out.print(node.element + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListExample example1 = new LinkedListExample();
        LinkedListExample example2 = new LinkedListExample();
        example1.insert(new int[]{1, 3, 4, 7, 9});
        example1.printAll(example1.head);
        example2.insert(new int[]{1, 2, 3, 5, 10});
        example2.printAll(example2.head);
        //LinkedListExample.Node node = example1.mergeTwoSortedLinkedList(example1.head, example2.head);
        LinkedListExample.Node node = example1.mergeTwoLists(example1.head, example2.head);
        example2.printAll(node);

        example1.printAll(example1.reverse(example2.head));

    }

}