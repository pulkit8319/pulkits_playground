package com.pulkit.ds.practice.leetCode.Array;

//Given a binary array, find the maximum number of consecutive 1s in this array.
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int nums[] = {1,1,0,1,1,1};
		int num = findMaxConsecutiveOnes(nums);
		System.out.println(num);
	}

	private static int findMaxConsecutiveOnes(int[] nums) {
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==1){
				count++;
			}else{
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}
		maxCount = Math.max(maxCount, count);
		return maxCount;
	}

}
