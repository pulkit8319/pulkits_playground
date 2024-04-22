package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		headA.next.next.next.next = new ListNode(6);
		ListNode headB = new ListNode(7);
		headB.next = new ListNode(8);
		headB.next.next = new ListNode(9);
		headB.next.next.next = new ListNode(10);
		headB.next.next.next.next = headA.next.next.next;
		ListNode node = getIntersectionNode(headA, headB);
		System.out.println(node.val);
	}

	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null){
			return null;
		}
		ListNode head1 = headA, head2 = headB;
		int lenA = 0, lenB = 0;
		while (head1 != null) {
			lenA++;
			head1 = head1.next;
		}
		while (head2 != null) {
			lenB++;
			head2 = head2.next;
		}
		int diff = lenA > lenB ? lenA - lenB : lenB - lenA;
		head1 = headA;
		head2 = headB;
		if(lenA>lenB){
			while(diff>0){
				head1 = head1.next;
				diff--;
			}
		}else{
			while(diff>0){
				head2 = head2.next;
				diff--;
			}
		}
		while(head1!=null && head2!=null){
			if(head1.equals(head2)){
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
