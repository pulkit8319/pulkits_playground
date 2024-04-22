package com.pulkit.ds.practice.leetCode.DP;

//Given a string s and a string t, check if s is subsequence of t.
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//Follow up:
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
public class IsSubsequenceString {

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		boolean isSubsequence = isSubsequenceDP(s,t);
		System.out.println(isSubsequence);
	}

	private static boolean isSubsequenceDP(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		boolean[][] dp = new boolean[sLen+1][tLen+1];
		for(int i=0;i<=tLen;i++){
			dp[0][i] = true;
		}
		for(int i=1;i<=sLen;i++){
			dp[i][0] = false;
		}
		for(int i=1;i<=sLen;i++){
			for(int j=1;j<=tLen;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		return dp[sLen][tLen];
	}

	private static boolean isSubsequence(String s, String t) {
		int sLen = 0;
		int tLen = 0;
		if(s.isEmpty()){
			return true;
		}
		while(sLen<s.length() && tLen<t.length()){
			if(s.charAt(sLen) == t.charAt(tLen)){
				sLen++;
			}
			if(sLen>=s.length()){
				return true;
			}
			tLen++;
		}
		return false;
	}
     
}
