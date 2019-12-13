package com.fh.project.algo.linkedlist;

/**
 * 判断是否是回文字符串，链表实现
 */
public class PalindromeLinkedList2<T> {

    private Node head;

    public PalindromeLinkedList2(String str) {
        // 初始化链表
        String[] split = str.split("");
        for (String s : split) {
            Node newNode = new Node(s);
            // 第一个节点
            if (head == null) {
                head = newNode;
            } else {
                // 获取尾节点
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                // 设置新节点到尾节点的next引用
                tail.next = newNode;
            }

        }
    }

    // 使用快慢指针获取中间节点
    public Node getCenterNode() {
        // 1、如果链表为null，或者只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 2、定义快慢节点
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) {
            // 代表slow节点是中间节点，链表数量为奇数
            return slow;
        } else {
            return slow;
        }
    }

    // 判断是否为回文字符串
    public boolean palindromeLinked() {
        // 1、如果链表为null，或者只有一个节点
        if (head == null || head.next == null) {
            return true;
        }
        // 2、根据快慢引用获取中间节点
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3、定义左边链表和右边链表
        Node leftLink = null;
        Node rightLink = null;
        if (fast.next == null) {
            // 代表slow节点是中间节点，链表数量为奇数
            rightLink = slow.next;
            leftLink = reverse(slow).next;
        } else {
            // slow 和slow.next都是中间节点
            rightLink = slow.next;
            leftLink = reverse(slow);
        }

        return compareLinkedList(leftLink, rightLink);
    }

    // 比较两个链表的值是否相等
    public boolean compareLinkedList(Node leftLink, Node rightLink) {
        while (leftLink != null && rightLink != null) {
            if(!leftLink.element.equals(rightLink.element)){
                System.out.println("不是回文字符串");
                return false;
            }
            leftLink = leftLink.next;
            rightLink = rightLink.next;

        }
        System.out.println("是回文字符串");
        return true;
    }

    // 链表反转,反转head到node节点之间的数据
    private Node reverse(Node node) {
        Node curr = head;
        Node pre = null;
        Node next = null;
        while (curr != node) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        // 注意：还要再赋值一次
        curr.next = pre;
        pre = curr;
        return pre;
    }

    public class Node<T> {

        private T element;

        private Node next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    private void printAll(Node node) {
        while (node != null) {
            System.out.print(node.element + ",");
            node = node.getNext();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str = "m2ono2m";
        PalindromeLinkedList2 list = new PalindromeLinkedList2(str);
        list.palindromeLinked();
    }

}