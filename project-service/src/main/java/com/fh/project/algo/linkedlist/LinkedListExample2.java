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

    /*
        单链表反转：
     */
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
        // 使用哨兵节点
        Node soldier = new Node(null);
        Node p = soldier;
        while (node1 != null && node2 != null) {
            if ((int) node1.t > (int) node2.t) {
                p.next = node2;
                node2 = node2.next;
            } else {
                p.next = node1;
                node1 = node1.next;
            }
            // 后移一位
            p = p.next;
        }
        if (node1 != null) {
            // 获取末尾的tail
            p.next = node1;
        } else {
            p.next = node2;
        }
        return soldier.next;
    }

    /*  删除倒数第K个结点
        1、快指针先到达第k个位置
        2、快慢指针同时走，当快指针走到链表尾端，慢指针此时的位置正好是要删除的节点
        3、定义一个前置节点，用来保存慢指针的前一个位置
        4、删除节点
     */
    public Node deleteLastKth(Node list, int k) {

        // 快指针先走，先到达第k个位置
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        // 如果第k个位置的快指针为null，代表链表没那么长
        if (fast == null) return list;

        // 此时快慢指针再同时执行直到快指针走到链表尾部，慢指针此时的位置刚好是要删除的那个节点
        Node slow = list;
        // 定义一个引用用来保存要删除节点的前一个节点
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        prev.next = prev.next.next;
        return list;
    }

    // 求链表的中间结点
    public static Node getCenterNodeList(Node node) {
        if (node == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    // 链表中环的检测
    public static boolean checkCycle(Node node) {
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

        // 测试删除倒数第n个节点
        LinkedListExample2 example4 = new LinkedListExample2(new int[]{1, 3, 8, 9, 10});
        Node deleteTailNode = example4.deleteLastKth(example4.head, 6);
        example4.printAll(deleteTailNode);

    }
}
