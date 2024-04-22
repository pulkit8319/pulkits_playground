package com.pulkit.ds.practice.leetCode.Array;

//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You may assume no duplicates in the array.
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int index = searchInsertOptimised(nums, 7);
		System.out.print(index);
	}

	private static int searchInsertOptimised(int[] nums, int target) {
		int low = 0;
		int high = nums.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			int num = nums[mid];
			if(num==target){
				return mid;
			}else if(num>target){
				high = mid-1;
			}else{
				low = mid+1; 
			}
		}
		return low;
	}

	private static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		if(target<=nums[0]){
			return 0;
		}
		if(target>nums[n-1]){
			return n;
		}
		if(target==nums[n-1]){
			return n-1;
		}
		for (int i = 0; i < n-1; i++) {
			if(nums[i]==target){
				return i;
			}else if(nums[i]<target && nums[i+1]>target){
				return i+1;
			}
		}
		return 0;
	}

}
