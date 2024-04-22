package com.pulkit.ds.practice.leetCode.DP;

//Given a square array of integers A, we want the minimum sum of a falling path through A.
//A falling path starts at any element in the first row,and chooses one element from each row.The next row'schoice must be in a column that is different from the previous row'scolumn by at most one.
public class MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int minPathSum = minFallingPathSum(A);
		System.out.println(minPathSum);
	}

	private static int minFallingPathSum(int[][] A) {
		int x = A.length;
		int y = A[0].length;
		int sum = 0;
		if(x>0 && y>0){
			for(int i = x-2;i>=0;i--){
				for(int j = y-1;j>=0;j--){
					if(j==0){
						A[i][j] = A[i][j] + Math.min(A[i+1][j], A[i+1][j+1]);
					}else if(j==y-1){
						A[i][j] = A[i][j] + Math.min(A[i+1][j-1], A[i+1][j]);
					}else{
						A[i][j] = A[i][j] + Math.min(Math.min(A[i+1][j-1], A[i+1][j]),A[i+1][j+1]);
					}
				}
			}
			sum = Integer.MAX_VALUE;
			for(int i=0;i<x;i++){
				sum = Math.min(sum, A[0][i]);
			}
		}
		return sum;
	}

}
