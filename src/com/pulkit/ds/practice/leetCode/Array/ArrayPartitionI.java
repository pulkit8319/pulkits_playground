package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;

//Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
public class ArrayPartitionI {

	public static void main(String[] args) {
		int nums[] = {1,4,3,2};
		int sum = arrayPairSum(nums);
		System.out.println(sum);
	}

	private static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i = i+2){
            sum+=nums[i];
        }
        return sum;
	}

}
