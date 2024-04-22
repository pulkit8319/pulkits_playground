package com.pulkit.ds.practice.leetCode.Array;

//Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
//You may return any answer array that satisfies this condition.
public class SortArrayByParity {

	public static void main(String[] args) {
		int[] arr = {3,1,2,4};
		int[] nums = sortArrayByParity(arr);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

	private static int[] sortArrayByParity(int[] A) {
		int k = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]%2==0){
				int temp = A[k];
				A[k] = A[i];
				A[i] = temp;
				k++;
			}
		}
		return A;
	}

}
