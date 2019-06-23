package linkedList.List;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBeginning(new ListNode("23"));
		list.insert("34", 89);
		list.insertAtEnd(new ListNode("98"));
		list.insert("9", -2);
		list.printList();
		list.deleteFirst();
		System.out.println("--------------");
		list.printList();
		list.delete(2);
		System.out.println("--------------");
		list.printList();
		list.deleteLast();
		System.out.println("--------------");
		list.printList();
		list.insert("9", -2);
		System.out.println("--------------");
		list.printList();
	}
}
