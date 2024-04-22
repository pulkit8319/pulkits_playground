package stack;

import java.util.Stack;

public class BalancedExpressions {

	public static void main(String[] args) {
		String exp = "";
		boolean isBalanced = isExpBalanced(exp);
		System.out.println(isBalanced);
	}

	private static boolean isExpBalanced(String exp) {
		char[] arr = exp.toCharArray();
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if ('(' == arr[i] || '{' == arr[i] || '[' == arr[i]) {
				stk.push(arr[i]);
			} else if (')' == (arr[i]) || '}' == (arr[i]) || ']' == (arr[i])) {
				char k;
				if(stk.empty()) {
					return false;
				}else {
					k = stk.pop();
				}
				if (!((')' == arr[i] && '(' == k) || ('}' == arr[i] && '{' == k) || (']' == arr[i] && '[' == k))) {
					return false;
				}
			}
		}
		return stk.isEmpty() ? true : false;
	}

}
