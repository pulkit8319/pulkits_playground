package com.pulkit.ds.practice.leetCode.DP;

//We write the integers of A and B (in the order they are given) on two separate horizontal lines.
//Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
//A[i] == B[j];
//The line we draw does not intersect any other connecting (non-horizontal) line.
//Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
//Return the maximum number of connecting lines we can draw in this way.
public class UncrossedLines {

	public static void main(String[] args) {
		int A[] = {1,4,2};
		int B[] = {1,2,4};
		int maxLines = maxUncrossedLines(A,B);
		System.out.println(maxLines);
	}

	private static int maxUncrossedLines(int[] A, int[] B) {
		
		return 0;
	}

}
