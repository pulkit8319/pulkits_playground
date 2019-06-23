package linkedList.List;

public class LinkedList {

	public ListNode head;

	public int length;

	public LinkedList() {
		this.length = 0;
	}

	public void printList() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void insert(String data, int position) {
		if (position < 0) {
			position = 0;
		} else if (position > length) {
			position = length;
		}
		if (head == null) {
			head = new ListNode(data);
		}
		if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else {
			ListNode temp = head;
			while (position > 1) {
				temp = temp.next;
				position--;
			}
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		length++;
	}

	public void insertAtBeginning(ListNode node) {
		node.next = head;
		head = node;
		length++;
	}

	public void insertAtEnd(ListNode node) {
		ListNode temp = head;
		while (head.next != null) {
			head = head.next;
		}
		head.next = node;
		head = temp;
		length++;
	}

	public void deleteFirst() {
		if (head != null) {
			ListNode temp = head.next;
			head = null;
			head = temp;
		}
		length--;
	}

	public void deleteLast() {
		// 1.2.3.4
		ListNode temp = head;
		ListNode prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		temp = null;
		prev.next = null;
		length--;
	}

	public void delete(int position) {
		if (position < 0) {
			position = 0;
		} else if (position > length) {
			position = length;
		}
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (position == 0) {
			head = head.next;
		} else {// 1.2.3.4 pos=2
			ListNode temp = head;
			while (position > 1) {
				temp.next = temp.next.next;
				position--;
			}
		}
		length--;
	}

	public int getLength() {
		return length;
	}
}
