package com.pulkit.ds.practice.leetCode.String;

//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
public class LeetCodeValidPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		boolean isValidPalindrome = isPalindrome(s);
		System.out.println(isValidPalindrome);
	}

	private static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			char left = s.charAt(l);
			char right = s.charAt(r);
			if (!((left >= 48 && left <= 57) || (left >= 65 && left <= 90)
					|| (left >= 97 && left <= 122))) {
				l++;
			} else if (!((right >= 48 && right <= 57) || (right >= 65 && right <= 90)
					|| (right >= 97 && right <= 122))) {
				r--;
			} else if (left == right) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}

}
