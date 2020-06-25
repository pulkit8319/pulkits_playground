package com.pulkit.ds.practice.leetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//Note:
//The same word in the dictionary may be reused multiple times in the segmentation.
//You may assume the dictionary does not contain duplicate words.

public class WordBreak {

	public static void main(String[] args) {
		String s = "aaaaaaa";
		List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
		boolean b = wordBreakDP(s, wordDict);
		System.out.println(b);
	}

	private static boolean wordBreakDP(String s, List<String> wordDict) {
		int size = s.length();
		if (size == 0) {
			return true;
		}
		boolean[] dp = new boolean[size + 1];
		dp[0] = true;
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[size];
	}

	private static boolean wordBreak(String s, List<String> wordDict) {
		int size = s.length();
		if (size == 0) {
			return true;
		}
		for (int i = 1; i <= size; i++) {
			if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i, size), wordDict)) {
				return true;
			}
		}
		return false;
	}

}
