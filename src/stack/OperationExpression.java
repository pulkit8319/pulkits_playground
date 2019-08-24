package stack;

import java.util.Stack;

public class OperationExpression {

	public static void main(String[] args) {
		String[] exp = "987*+5-".split("");
		int result = doOperation(exp);
		System.out.println(result);
	}

	private static int doOperation(String[] exp) {
		Stack<Integer> stk = new Stack<>();
		int a, b, c;
		for (int i = 0; i < exp.length; i++) {
			if (exp[i].equals("+")) {
				a = stk.pop();
				b = stk.pop();
				c = a + b;
				stk.push(c);
			} else if (exp[i].equals("-")) {
				a = stk.pop();
				b = stk.pop();
				c = b - a;
				stk.push(c);
			} else if (exp[i].equals("*")) {
				a = stk.pop();
				b = stk.pop();
				c = a * b;
				stk.push(c);
			} else if (exp[i].equals("/")) {
				a = stk.pop();
				b = stk.pop();
				c = b / a;
				stk.push(c);
			} else {
				stk.push(Integer.parseInt(exp[i]));
			}
		}
		return stk.pop();
	}

}
