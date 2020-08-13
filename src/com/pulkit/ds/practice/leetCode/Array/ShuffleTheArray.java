package com.pulkit.ds.practice.leetCode.Array;

//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//Return the array in the form [x1,y1,x2,y2,...,xn,yn].
public class ShuffleTheArray {

	public static void main(String[] args) {
		int[] nums = {1};
		int[] num = shuffle(nums, 1);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}

	private static int[] shuffle(int[] nums, int n) {
		int m = 0;
		int k = n;
		int i = 0;
		int[] arr = new int[2*n];
		while(m<n){
			arr[i++] = nums[m++];
			arr[i++] = nums[k++];
		}
		return arr;
	}

}
