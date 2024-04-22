package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {

	public static void main(String[] args) {
		CustomStack customStack = (new StackUsingTwoQueue()).new CustomStack();
		customStack.push(2);
		customStack.push(9);
		customStack.push(3);
		customStack.push(5);
		System.out.println(customStack.pop());
		System.out.println(customStack.pop());
		System.out.println(customStack.pop());
	}

	public class CustomStack {
		Queue<Integer> mainQueue = new LinkedList<>();
		Queue<Integer> auxQueue = new LinkedList<>();

		public void push(Integer i) {
			mainQueue.add(i);
		}

		public Integer pop() {
			int size = mainQueue.size();
			for (int i = 0; i < size - 1; i++) {
				auxQueue.add(mainQueue.poll());
			}
			int j = mainQueue.poll();
			while (!auxQueue.isEmpty()) {
				mainQueue.add(auxQueue.poll());
			}
			return j;
		}
	}

}
