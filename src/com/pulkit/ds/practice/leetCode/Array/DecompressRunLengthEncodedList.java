package com.pulkit.ds.practice.leetCode.Array;

//Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
//Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
public class DecompressRunLengthEncodedList
{

	public static void main(String[] args) {
		int[] nums = {1,1,2,3};
		int[] b = decompressRLElist(nums);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
	}

	private static int[] decompressRLElist(int[] nums) {
		int n = 0;
		for (int i = 0; i < nums.length; i+=2) {
			n+=nums[i];
		}
		int arr[] = new int[n];
		int k = 0;
		for (int i = 0; i < arr.length; i+=2) {
			int freq = nums[i];
			int num = nums[i+1];
			while(freq>0){
				arr[k++] = num;
				freq--;
				if(k>=n){
					return arr;
				}
			}
			
		}
		return arr;
	}

}
