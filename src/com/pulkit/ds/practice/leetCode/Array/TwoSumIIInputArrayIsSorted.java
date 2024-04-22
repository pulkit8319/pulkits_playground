package com.pulkit.ds.practice.leetCode.Array;

//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//Note:
//Your returned answers (both index1 and index2) are not zero-based.
//You may assume that each input would have exactly one solution and you may not use the same element twice.
public class TwoSumIIInputArrayIsSorted {

	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int[] indices = twoSum(numbers,9);
		for (int i = 0; i < indices.length; i++) {
			System.out.println(indices[i]);
		}
	}

	private static int[] twoSum(int[] numbers, int target) {
		int num[] = new int[2];
		int l=0,r = numbers.length-1;
		while(l<r){
			int num1 = numbers[l];
			int num2 = numbers[r];
			if(num1+num2==target){
				num[0]=l+1;
				num[1]=r+1;
				break;
			}else if(num1+num2<target){
				l++;
			}else{
				r--;
			}
		}
		return num;
	}

}
