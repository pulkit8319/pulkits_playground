package linkedList;

import linkedList.List.LinkedList;
import linkedList.List.ListNode;

public class FindMiddleOfALinkedList {

	static LinkedList list = new LinkedList();

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode("12"));
		list.insert("98", 90);
		list.insert("65", 90);
		list.insert("17", 90);
		list.insert("23", 90);
		list.insert("87", 90);
		list.insert("45", 90);
		findMiddle(list.head);
		list.printList();
	}

	private static void findMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle is " + slow.data);
	}
}
