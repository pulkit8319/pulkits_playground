package com.pulkit.ds.practice.leetCode.Array;

//Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
public class CheckIfItsAStraightLine {

	public static void main(String[] args) {
		int coordinates[][] = { { 0, 0 }, { 0, 1 }, { 0, -1 } };
		boolean b = checkStraightLine(coordinates);
		System.out.println(b);
	}

	private static boolean checkStraightLine(int[][] coordinates) {
		int n = coordinates.length;
		if (n == 1 || n == 0) {
			return true;
		}
		for (int i = 1; i < n - 1; i++) {
			int yDiff1 = coordinates[i][1] - coordinates[i - 1][1];
			int xDiff1 = coordinates[i][0] - coordinates[i - 1][0];
			int yDiff2 = coordinates[i + 1][1] - coordinates[i][1];
			int xDiff2 = coordinates[i + 1][0] - coordinates[i][0];
			if ((yDiff1*xDiff2)!=(yDiff2*xDiff1)) {
				return false;
			}
		}
		return true;
	}

}
