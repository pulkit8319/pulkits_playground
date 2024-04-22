package com.pulkit.ds.practice.leetCode.Array;

//A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
//Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		boolean isToeplitz = isToeplitzMatrix(matrix);
		System.out.println(isToeplitz);
	}

	private static boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length-1; i++) {
			for (int j = 0; j < matrix[0].length-1; j++) {
				if (matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		return true;
	}

}
