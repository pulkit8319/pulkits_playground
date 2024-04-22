package linkedList;

import linkedList.List.LinkedList;
import linkedList.List.ListNode;

public class InsertInSortedList {
	static LinkedList list = new LinkedList();

	public static void main(String[] args) {
		list.insertAtBeginning(new ListNode("12"));
		list.insert("17", 90);
		list.insert("23", 90);
		list.insert("45", 90);
		list.printList();
		insert("11");
		System.out.println("-------------------");
		list.printList();
		insert("78");
		System.out.println("-------------------");
		list.printList();
		insert("55");
		System.out.println("-------------------");
		list.printList();
	}

	private static void insert(String i) {
		ListNode temp = list.head;
		if (Integer.parseInt(i) < Integer.parseInt(list.head.data)) {
			list.head = new ListNode(i);
			list.head.next = temp;
			return;
		}
		ListNode node = null;
		while (temp != null && Integer.valueOf(i) > Integer.valueOf(temp.data)) {
			node = temp;
			temp = temp.next;
		}
		ListNode newNode = new ListNode(i);
		node.next = newNode;
		newNode.next = temp;
		list.length++;
	}

}
