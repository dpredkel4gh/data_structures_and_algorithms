package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LinkedListPalindrome {
    public static void main(String[] a) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1, listNode);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);
        ListNode listNode5 = new ListNode(1, listNode4);

        System.out.println(isPalindrome(listNode5));
        System.out.println(isPalindrome2(listNode5));
    }


    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currentValue = head;
        while (currentValue != null) {
            list.add(currentValue.val);
            currentValue = currentValue.next;
        }

//     [1,2,3], size=3, Math.floor(list.size()/2)

        for (int i = 0, j = list.size() - 1; i < Math.floor((double) list.size() / 2); i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
