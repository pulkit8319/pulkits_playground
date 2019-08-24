package queue;

import java.util.Stack;

public class QueueUsingTwoStack {
	
	public static void main(String[] args) {
		
		CustomQueue queue = (new QueueUsingTwoStack()).new  CustomQueue();
		queue.enqueue(6);
		queue.enqueue(8);
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println("1st number---"+queue.dequeue());
		System.out.println("2nd number---"+queue.dequeue());
	}
	
	public class CustomQueue{
		Stack<Integer> mainStack = new Stack<>();
		Stack<Integer> auxStack = new Stack<>();
		
		public void enqueue(Integer i) {
			mainStack.push(i);
		}
		
		public Integer dequeue() {
			if(auxStack.isEmpty()) {
				while(!mainStack.isEmpty()) {
					auxStack.push(mainStack.pop());
				}
			}
			return auxStack.pop();
		}
		
	}

}
