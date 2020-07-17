package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;

//Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
//The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
public class FindTheDistanceBetweenTwoArrays {
	
	public static void main(String[] args) {
		int[] arr1 = {7,9,4}, arr2 = {-10};
		int d = 29;
		int num = findTheDistanceValue(arr1, arr2,d);	
			System.out.println(num);
	}

	private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		Arrays.sort(arr2);
		//1,4,2,2
		//-2,-1,0,
		//3
		int l = 0;
		int m = 0;
		int r = arr2.length-1;
		while(m<=r && arr2[m]<0 ){
			m++;
		}
		int m1 = m;
		if(m<r-1){
			m1 = m+1;
		}
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			if(Math.abs(arr1[i]-arr2[l])>d && Math.abs(arr1[i]-arr2[m])>d && Math.abs(arr1[i]-arr2[m1])>d&& Math.abs(arr1[i]-arr2[r])>d){
				count++;
			}
		}
		return count;
	}

}
