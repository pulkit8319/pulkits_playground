package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAccoToPassedIndex {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(2);
		queue.add(12);
		queue.add(87);
		queue.add(65);
		queue.add(10);
		queue.add(89);
		queue.add(54);
		System.out.println(queue);
		reverse(queue,5);
		System.out.println(queue);
	}

	private static void reverse(Queue<Integer> queue, int i) {
		Stack<Integer> stack = new Stack<>();
		int k = i;
		while(i>0) {
			stack.push(queue.poll());
			i--;
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		for(int j=0;j<queue.size()-k;j++) {
			queue.add(queue.poll());
		}
	}

}
