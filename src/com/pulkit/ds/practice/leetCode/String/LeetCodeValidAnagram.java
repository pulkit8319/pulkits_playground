package com.pulkit.ds.practice.leetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
public class LeetCodeValidAnagram {

	public static void main(String[] args) {
		String s1 = "abl";
		String s2 = "lkj";
		boolean isAnagram = isAnagram1(s1, s2);
		System.out.println(isAnagram);
	}

	// bad solution
	private static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		List<Character> lst = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			lst.add(s.charAt(i));
		}
		for (int i = 0; i < t.length(); i++) {
			lst.remove((Character) t.charAt(i));
		}
		if (lst.isEmpty())
			return true;
		return false;
	}

	// good solution
	private static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] charArray = s.toCharArray();
		char[] charArray2 = t.toCharArray();
		Arrays.sort(charArray);
		Arrays.sort(charArray2);
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i]!=charArray2[i])
				return false;
		}
		return true;
	}
	
	// best solution
		private static boolean isAnagram2(String s, String t) {
			if (s.length() != t.length())
				return false;
			int counter[] = new int[26];
			for (int i = 0; i < s.length(); i++) {
				counter[s.charAt(i)-'a']++;
				counter[t.charAt(i)-'a']--;
			}
			for (int i = 0; i < counter.length; i++) {
				if(counter[i]>0)
					return false;
			}
			return true;
		}

}
