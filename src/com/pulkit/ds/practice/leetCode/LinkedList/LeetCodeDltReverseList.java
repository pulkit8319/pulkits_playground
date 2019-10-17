package com.pulkit.ds.practice.leetCode.LinkedList;

public class LeetCodeDltReverseList {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(9);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		head = reverseList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = head.next;
		while(next!=null) {
			head.next = prev;
			prev = head;
			head = next;
			next = head.next;
		}
		head.next = prev;
		return head;
	}
}
