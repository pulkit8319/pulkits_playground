package linkedList;

import java.util.List;

import linkedList.List.LinkedList;
import linkedList.List.ListNode;

public class ReverseSinglyLinkedList {

	static LinkedList list = new LinkedList();

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode("12"));
		list.insert("17", 90);
		list.insert("23", 90);
		list.insert("45", 90);
		list.printList();
		reverseListRecursive(list.head);
		System.out.println("-----------------");
		list.printList();
	}

	private static ListNode reverseListIterative(ListNode head) {// 1.2.3.4.2
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		list.head = prev;
		return list.head;
	}
	
	private static void reverseListRecursive(ListNode current) {
		if(current.next==null) {
			list.head = current;
			return;
		}
		reverseListRecursive(current.next);
		ListNode q = current.next;
		q.next = current;
		current.next = null;
	}
}
