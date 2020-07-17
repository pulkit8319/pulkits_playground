package com.pulkit.ds.practice.leetCode.Array;

//Given a matrix A, return the transpose of A.
//The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
public class TransPoseMatrix {

	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		A = transpose(A);
	}

	private static int[][] transpose(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int ans[][] = new int[c][r];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
					ans[j][i] = A[i][j];
			}
		}
		return ans;
	}
	
}
