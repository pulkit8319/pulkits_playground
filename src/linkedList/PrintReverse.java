package linkedList;

import linkedList.List.LinkedList;
import linkedList.List.ListNode;

public class PrintReverse {
	
	static LinkedList list = new LinkedList();

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode("12"));
		list.insert("98", 90);
		list.insert("65", 90);
		list.insert("17", 90);
		list.insert("23", 90);
		list.insert("87", 90);
		list.insert("45", 90);
		list.printList();
		System.out.println("---------------------");
		printReverse(list.head);
	}

	private static void printReverse(ListNode head) {
		if(head==null)
			return;
		printReverse(head.next);
		System.out.println(head.data);
	}
}
