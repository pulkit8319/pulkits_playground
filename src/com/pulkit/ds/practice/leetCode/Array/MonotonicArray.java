package com.pulkit.ds.practice.leetCode.Array;

//An array is monotonic if it is either monotone increasing or monotone decreasing.
//An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
//Return true if and only if the given array A is monotonic.
public class MonotonicArray {

	public static void main(String[] args) {
		int[] nums = {1,2,4,5};
		boolean b = isMonotonic(nums);
		System.out.println(b);
	}

	private static boolean isMonotonic(int[] A) {
		boolean inc = true;
		int n = A.length;
		if(A[0]>A[n-1]){
			inc = false;
		}else if(A[0]==A[n-1]){
			return true;
		}
		for (int i = 0; i < A.length-1; i++) {
			if(inc){
				if(A[i]>A[i+1]){
					return false;
				}
			}else{
				if(A[i]<A[i+1]){
					return false;
				}
			}
		}
		return true;
	}

	

}
