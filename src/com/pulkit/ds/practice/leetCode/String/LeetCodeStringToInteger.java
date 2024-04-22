package com.pulkit.ds.practice.leetCode.String;

/*Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.*/
public class LeetCodeStringToInteger {

	public static void main(String[] args) {
		String s = "2147483648";
		int num = myAtoi(s);
		System.out.println(num);
	}

	private static int myAtoi(String str) {
		str = str.trim();
		if(str.isEmpty())
			return 0;
		int j = Integer.MAX_VALUE;
		String num = new String();
		char ch = str.charAt(0);
		if (ch == '-' || ch == '+' || (ch >= 48 && ch <= 57)) {
			for (int k = 1; k < str.length(); k++) {
				char ch1 = str.charAt(k);
				if (ch1 >= 48 && ch1 <= 57) {
					num += ch1;
				} else {
					break;
				}
			}
			if(ch=='-')
				j = Integer.MIN_VALUE;
			num = ch+num;
			if(num.equals("+") || num.equals("-"))
				return 0;
			try {
				j = Integer.parseInt(num);
			} catch (Exception e) {
				return j;
			}
			return j;
		} else {
			return 0;
		}
	}

}
