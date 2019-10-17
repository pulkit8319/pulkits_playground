package com.pulkit.ds.practice.leetCode.String;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
public class LeetCodeFirstUnique {

	public static void main(String[] args) {
		String s = "loveleetcode";
		int index = firstUniqChar1(s);
		System.out.println(index);
	}

	private static int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	// good solution
	private static int firstUniqChar1(String s) {
		for (int i = 0; i < s.length(); i++) {
			if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i;
		}
		return -1;
	}
}
