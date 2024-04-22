package com.pulkit.ds.practice.leetCode.Array;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//Note:
//The number of elements initialized in nums1 and nums2 are m and n respectively.
//You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
public class MergeSortedArray {

	public static void main(String[] args) {
		int nums1[] = {1,2,0,0,0};
		int nums2[] = {2,5,6};
		merge(nums1,2,nums2,3);
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1,j=n-1,k = m+n-1;
		while(i>-1 && j>-1){
			if(nums1[i]>=nums2[j]){
				nums1[k--] = nums1[i--];
			}else{
				nums1[k--] = nums2[j--];
			}
		}
		while(i>-1){
			nums1[k--] = nums1[i--]; 
		}
		while(j>-1){
			nums1[k--] = nums2[j--];
		}
	}

}
