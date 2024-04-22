package com.pulkit.ds.practice.leetCode.DP;

//Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
public class RangeSumQuery2D {

	static int[][] dp;

	// Individual row sum START //
	/*
	 * public RangeSumQuery2D(int[][] matrix) { if (matrix.length > 0 &&
	 * matrix[0].length > 0) { int x = matrix.length; int y = matrix[0].length;
	 * dp = new int[x][y + 1]; for (int i = 0; i < x; i++) { for (int j = 0; j <
	 * y; j++) { dp[i][j + 1] = dp[i][j] + matrix[i][j]; } } } }
	 * 
	 * public static int sumRegion(int row1, int col1, int row2, int col2) { int
	 * sum = 0; for (int i = row1; i <= row2; i++) { sum += dp[i][col2 + 1] -
	 * dp[i][col1]; } return sum; }
	 */

	// Individual row sum START //

	public RangeSumQuery2D(int[][] matrix) {
		if (matrix.length > 0 && matrix[0].length > 0) {
			int x = matrix.length;
			int y = matrix[0].length;
			dp = new int[x + 1][y + 1];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + matrix[i][j] - dp[i][j];
				}
			}
		}
	}

	public static int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		RangeSumQuery2D rr = new RangeSumQuery2D(matrix);
		System.out.println(rr.sumRegion(2, 1, 4, 3));
	}
}
