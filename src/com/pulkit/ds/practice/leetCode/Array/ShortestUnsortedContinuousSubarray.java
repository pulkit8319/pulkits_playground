package com.pulkit.ds.practice.leetCode.Array;

//Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
//You need to find the shortest such subarray and output its length.
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		int[] nums = {1,3,2,2,2};
		int len = findUnsortedSubarray(nums);
		System.out.print(len);
	}

	private static int findUnsortedSubarray(int[] nums) {
		int l = 0;
		int n = nums.length;
		int r = n-1;
		while(l<n-1 && nums[l]<=nums[l+1]){
			l++;
		}
		while(r>0 && nums[r-1]<=nums[r]){
			r--;
		}
		if(l<r){
			return r-l+1;
		}
		return 0;
	}

	

}
