package stack;

import java.util.Stack;

public class MinimumInAStack {

	public static void main(String[] args) {
		AuxStack<Integer> stk = (new MinimumInAStack()).new AuxStack();
		stk.push(7);
		stk.push(9);
		System.out.println(stk.getMinimum());
		stk.push(6);
		System.out.println(stk.getMinimum());
		stk.pop();
		System.out.println(stk.getMinimum());
	}

	public class AuxStack<Integer> extends Stack<Integer> {
		private Stack<Integer> mainStack = new Stack<Integer>();
		private Stack<Integer> minStack = new Stack<Integer>();

		@Override
		public Integer push(Integer item) {
			mainStack.push(item);
			if (minStack.isEmpty() || (int) item < (int) minStack.peek()) {
				minStack.push(item);
			}
			System.out.println("main stack length "+mainStack.size());
			System.out.println("min stack length "+minStack.size());
			return item;
		}

		@Override
		public synchronized Integer pop() {
			if (mainStack.isEmpty())
				return null;
			if (mainStack.peek().equals(minStack.peek())) {
				minStack.pop();
			}
			System.out.println("main stack length "+mainStack.size());
			System.out.println("min stack length "+minStack.size());
			return mainStack.pop();
		}

		public Integer getMinimum() {
			Integer min = minStack.peek();
			return min;
		}
		
	}

}
