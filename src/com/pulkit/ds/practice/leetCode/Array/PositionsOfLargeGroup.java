package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//In a string S of lowercase letters, these letters form consecutive groups of the same character.
//For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
//Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
//The final answer should be in lexicographic order.
public class PositionsOfLargeGroup {

	public static void main(String[] args) {
		String s = "abcdddeeeeaabbbcd";
		List<List<Integer>> list = largeGroupPositions(s);
		System.out.println(list);
	}

	private static List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int i = 0;
		int n = S.length();
		for (int j = 0; j < n; j++) {
			if (j == n - 1 || S.charAt(j) != S.charAt(j + 1)) {
				if ((j - i + 1) >= 3) {
					list.add(new ArrayList<>(Arrays.asList(i, j)));
				}
				i = j + 1;
			}
		}
		return list;
	}

}
