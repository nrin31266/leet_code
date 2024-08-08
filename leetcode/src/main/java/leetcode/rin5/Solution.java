package leetcode.rin5;


import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    ListNode head;

    MyLinkedList(int...val){
        for (int i = 0; i < val.length; i++) {
            addLast(val[i]);
        }
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        ListNode current = head;
        if(head == null) return;
        else System.out.print("[");
        while (current != null) {

            if(current.next == null) System.out.print(current.val);
            else System.out.print(current.val + ",");
            current = current.next;
        }
        System.out.println("]");
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getLinkedList() {
        return head;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = getNumber(l1).add(getNumber(l2));
        System.out.println(sum);
        MyLinkedList list = new MyLinkedList();
        if (sum.equals(BigInteger.ZERO)) {
            list.addLast(0);
            return list.getLinkedList();
        }
        String numStr = sum.toString();
        for (int i = 0; i < numStr.length(); i++) {
            list.addFirst(numStr.charAt(i) - '0');
        }
        return list.getLinkedList();
    }

    private BigInteger getNumber(ListNode head) {
        BigInteger result = BigInteger.ZERO;
        BigInteger multiplier = BigInteger.ONE;
        while (head != null) {
            BigInteger num = BigInteger.valueOf(head.val);
            result = result.add(num.multiply(multiplier));
            multiplier = multiplier.multiply(BigInteger.TEN);
            head = head.next;
        }
        return result;
    }
}

class Main{
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList(9, 8, 4);

        MyLinkedList list2 = new MyLinkedList(5, 6, 4);

        Solution solution = new Solution();
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.setHead(solution.addTwoNumbers(list1.getLinkedList(), list2.getLinkedList()));
        linkedList.printList();
    }
}