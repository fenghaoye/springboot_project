package com.fh.project.algo.linkedlist;

/**
 * 链表案例：
 * 单链表反转
 * 两个有序的链表合并
 * 链表中环的检测
 * 删除链表倒数第 n 个结点
 * 求链表的中间结点
 */
public class LinkedListExample2 {

    // 单链表反转
    public Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node next = null;
        Node pre = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 两个有序的链表合并
    public Node mergerTwoNodeList(Node node1, Node node2) {
        Node node = null;
        while (node1 != null && node2 != null) {
            Node temp = null;
            if ((int) node1.t > (int) node2.t) {
                temp = new Node(node2.t);
                node2 = node2.next;
                node = insert(node, temp);
            } else {
                temp = new Node(node1.t);
                node1 = node1.next;
                node = insert(node, temp);
            }
        }

        // 循环得出最后一个节点
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }

        if (node1 != null) {
            // 获取末尾的tail
            tail.next = node1;
        } else {
            tail.next = node2;
        }

        return node;
    }

    private Node insert(Node head, Node temp) {
        if (head == null) {
            head = temp;
        } else {
            // 循环得出最后一个节点
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = temp;
        }
        return head;
    }

    // 初始化链表
    public LinkedListExample2(int[] nums) {
        for (int num : nums) {
            Node node = new Node(num);
            if (head == null) {
                head = node;
            } else {
                // 循环得出最后一个节点
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = node;
            }
        }
    }

    public void printAll(Node node) {
        while (node != null) {
            System.out.print(node.t + ",");
            node = node.next;
        }
        System.out.println();
    }

    private Node head;

    class Node<T> {
        T t;
        Node next;

        public Node(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 7, 6};
        LinkedListExample2 example1 = new LinkedListExample2(nums);
        example1.printAll(example1.head);
        Node reverse = example1.reverse(example1.head);
        example1.printAll(reverse);

        // 测试两个有序的node合并
        LinkedListExample2 example2 = new LinkedListExample2(new int[]{3, 5, 6, 7, 9});
        LinkedListExample2 example3 = new LinkedListExample2(new int[]{1, 3, 8, 9, 10});
        example2.printAll(example2.head);
        example3.printAll(example3.head);
        Node mergerTwoNodeList = example2.mergerTwoNodeList(example2.head, example3.head);
        example1.printAll(mergerTwoNodeList);
    }
}
