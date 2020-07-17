package com.pulkit.ds.practice.leetCode.Array;

//Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//You may return any answer array that satisfies this condition.
public class SortArrayByParityII {

	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4,0,0,4,3,3};
		int[] nums = sortArrayByParityIIInPlace(arr);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

	private static int[] sortArrayByParityIIInPlace(int[] A) {
		int n = A.length;
		int l=0,r=1;
		while(l<n && r<n){
			while(l<n && A[l]%2==0){
				l+=2;;
			}
			while(r<n && A[r]%2==1){
				r+=2;
			}
			if(r>=n || l>=n){
				break;
			}
			int temp = A[l];
			A[l] = A[r];
			A[r] = temp;
		}
		return A;
	}

	private static int[] sortArrayByParityII(int[] A) {
		int n = A.length;
		int ans[] = new int[n];
		int l = 0,r = 1;
		for (int i = 0; i < A.length; i++) {
			if(A[i]%2==0){
				ans[l] = A[i];
				l+=2;
			}else{
				ans[r] = A[i];
				r+=2;
			}
		}
		return ans;
	}

}
