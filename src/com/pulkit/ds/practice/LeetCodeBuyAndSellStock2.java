package com.pulkit.ds.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
public class LeetCodeBuyAndSellStock2 {
	
	public static void main(String[] args) {
		int arr[] = {3,3};
		int b[] = twoSumMap(arr, 6);
		System.out.println(b[0]+"    "+b[1]);
	}
	
	 private static int[] twoSumMap(int[] arr, int target) { 
		 Map<Integer,Integer> map = new HashMap<>();
		 for (int j = 0; j < arr.length; j++) {
			int temp = target - arr[j];
			if(map.containsKey(temp)) {
				return new int[] {map.get(temp),j};
			}
			map.put(arr[j], j);
		}
		return null;
	}

	public static int[] twoSum(int[] nums, int target) {
		 int[] dup = new int[nums.length];
		 for (int i = 0; i < nums.length; i++) {
			 dup[i] = nums[i];
		}
		 Arrays.sort(dup);//2,3,4
		 int arr[] =new int[2];
		 int l = 0;
		 int r = dup.length-1;
		while (l < r) {
			if (dup[l] + dup[r] < target) {
				l++;
			} else if (dup[l] + dup[r] > target) {
				r--;
			} else {
				l = dup[l];//3
				r = dup[r];//3
				break;
			}
		}
		for(int i=0;i<nums.length;i++) {
			if(l==nums[i]) {
				arr[0] = i;
				break;
			}
		}
		for(int i=0;i<nums.length;i++) {//3,2,4
			if(r==nums[i] && i!=arr[0]) {
				arr[1] = i;
				break;
			}
		}
	        return arr;
	    }

}
