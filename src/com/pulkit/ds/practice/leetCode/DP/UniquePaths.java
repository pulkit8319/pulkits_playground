package com.pulkit.ds.practice.leetCode.DP;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?
public class UniquePaths {

	public static void main(String[] args) {
		int noOfPaths = uniquePaths(7,3);
		System.out.println(noOfPaths);
	}

	private static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0;i<n;i++){
			dp[0][i] = 1;
		}
		for(int j=0;j<m;j++){
			dp[j][0] = 1;
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}

	
}
