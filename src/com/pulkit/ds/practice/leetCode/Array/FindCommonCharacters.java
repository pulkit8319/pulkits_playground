package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//You may return the answer in any order.
public class FindCommonCharacters {

	public static void main(String[] args) {
		String A[] = { "bella", "label", "roller" };
		List<String> list = commonChars(A);
		System.out.println(list);
	}

	private static List<String> commonChars(String[] A) {
		List<String> list = new ArrayList<String>();
		int prim[] = new int[26];
		Arrays.fill(prim, Integer.MAX_VALUE);
		for (String str : A) {
			int sec[] = new int[26];
			for (int i = 0; i < str.length(); i++) {
				sec[str.charAt(i) - 'a']++;
			}
			for (int i = 0; i < prim.length; i++) {
				prim[i] = Math.min(prim[i], sec[i]);
			}
		}
		for (int i = 0; i < prim.length; i++) {
			while (prim[i]-- > 0) {
				list.add(String.valueOf((char) ('a' + i)));
			}
		}
		return list;
	}

}
