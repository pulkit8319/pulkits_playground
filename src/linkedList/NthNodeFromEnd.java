package linkedList;

import linkedList.List.LinkedList;
import linkedList.List.ListNode;

public class NthNodeFromEnd {
	
	static LinkedList list = new LinkedList();
	public static void main(String[] args) {
		int nodeFrmEnd = 3;
		list.insertAtBeginning(new ListNode("12"));
		list.insert("18",90);
		list.insert("09",90);
		list.insert("13",90);
		list.insert("17",90);
		list.printList();
		System.out.println(nodeFrmEnd+" node from end - "+getNodeFromEnd(nodeFrmEnd));
	}

	private static String getNodeFromEnd(int i) {
		int fromStart = list.getLength()-i;
		ListNode temp = list.head;
		while(fromStart>0) {
			temp = temp.next;
			fromStart--;
		}
		return temp.data;
	}

}
