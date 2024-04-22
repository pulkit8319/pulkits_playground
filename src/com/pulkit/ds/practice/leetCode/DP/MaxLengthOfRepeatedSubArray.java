package com.pulkit.ds.practice.leetCode.DP;

//Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
public class MaxLengthOfRepeatedSubArray {

	public static void main(String[] args) {
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		int maxLength = findLength(A,B);
		System.out.println(maxLength);
	}

	private static int findLength(int[] A, int[] B) {
		int x = A.length;
		int y = B.length;
		int[][] dp = new int[x][y];
		int max = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(A[i]==B[j]){
					if(i>0 && j>0){
						dp[i][j] = dp[i-1][j-1]+1;
					}else{
						dp[i][j] = 1;
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

}
