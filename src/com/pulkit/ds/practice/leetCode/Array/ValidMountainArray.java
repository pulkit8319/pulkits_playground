package com.pulkit.ds.practice.leetCode.Array;

/*Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.*/
public class ValidMountainArray {

	public static void main(String[] args) {
		int[] A = { 2, 1 };
		boolean isMountain = validMountainArray(A);
		System.out.println(isMountain);
	}

	private static boolean validMountainArray(int[] A) {
		int i = 0;
		int n = A.length;
		while (i < n - 1 && A[i] < A[i + 1]) {
			i++;
		}
		if (i == 0 || i == n - 1) {
			return false;
		}
		while (i < n - 1 && A[i] > A[i + 1]) {
			i++;
		}
		return i == n - 1;
	}

}
