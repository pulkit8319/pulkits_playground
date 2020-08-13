package com.pulkit.ds.practice.leetCode.Array;

//You are given an array of strings words and a string chars.
//A string is good if it can be formed by characters from chars (each character can only be used once).
//Return the sum of lengths of all good strings in words.
public class FindNumbersWithEvenNumberOfDigits {

	public static void main(String[] args) {
		int nums[] = {437,315,322,431,686,264,442};
		int num = findNumbersOptimized(nums);
		System.out.println(num);
	}

	private static int findNumbersOptimized(int[] nums) {
		int count = 0;
		for(int i:nums){
			if((i>9 && i<100) || (i>999 && i<10000) || i==100000){
				count++;
			}
		}
		return count;
	}

	private static int findNumbers(int[] nums) {
		int count = 0;
		int j = 0;
		for (int i : nums) {
			j = 0;
			while(i>0){
				i = i/10;
				j++;
			}
			if(j%2==0){
				count++;
			}
		}
		return count;
	}

}
