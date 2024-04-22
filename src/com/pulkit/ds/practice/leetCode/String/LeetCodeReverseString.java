package com.pulkit.ds.practice.leetCode.String;

/*Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.*/
public class LeetCodeReverseString {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		reverseString(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	private static void reverseString(char[] s) {
		int l = 0;
		int r = s.length-1;
		while(l<r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
		}
		
	}
	
}
