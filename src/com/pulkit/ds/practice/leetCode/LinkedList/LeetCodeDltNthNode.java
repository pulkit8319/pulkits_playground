package com.pulkit.ds.practice.leetCode.LinkedList;

public class LeetCodeDltNthNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(9);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		ListNode node = head;
		int n = 1;
		ListNode head1 = deleteNthNode(head,n);
		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
	}
	
	public static ListNode deleteNthNode(ListNode head, int n) {
		if(head.next==null) {
			return null;
		}
		ListNode node = head;
		int length = 0;
		while(node!=null) {
			length++;
			node = node.next;
		}
		if(n==length) {
			head = head.next;
			return head;
		}
		n = length-n;
		node = head;
		while(n>1) {
			node = node.next;
			n--;
		}
		node.next = node.next.next;
		return head;
	}
}
