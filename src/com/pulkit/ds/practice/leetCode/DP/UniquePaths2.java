package com.pulkit.ds.practice.leetCode.DP;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
public class UniquePaths2 {

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int noOfPaths = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(noOfPaths);
	}

	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		obstacleGrid[0][0] = 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] != 1) {
				obstacleGrid[i][0] = obstacleGrid[i - 1][0];
			} else {
				obstacleGrid[i][0] = 0;
			}
		}
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] != 1) {
				obstacleGrid[0][i] = obstacleGrid[0][i - 1];
			} else {
				obstacleGrid[0][i] = 0;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] != 1) {
					obstacleGrid[i][j] = Math.abs(obstacleGrid[i - 1][j]) + Math.abs(obstacleGrid[i][j - 1]);
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}
		return obstacleGrid[m - 1][n - 1];
	}

}
