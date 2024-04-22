package com.pulkit.ds.practice.leetCode.Array;

//We have an array A of integers, and an array queries of queries.
//For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
//(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
//Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
public class SumOfEvenNumbersAfterQueries {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		int[][] queries = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
		int[] ans = sumEvenAfterQueries(A, queries);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	private static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				sum += A[i];
			}
		}
		int len = queries.length;
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			int index = queries[i][1];
			if (A[index] % 2 == 0) {
				sum -= A[index];
			}
			A[index] += queries[i][0];
			if (A[index] % 2 == 0) {
				sum += A[index];
			}
			ans[i]=sum;
		}
		return ans;
	}

}
