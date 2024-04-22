package com.pulkit.ds.practice.leetCode.Array;

import java.util.Stack;

//Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
//After doing so, return the array.
public class ReplaceElementsWithGreatestElementOnRightSide {

	public static void main(String[] args) {
		int[] arr = {2,3,1,4,6};
		int[] num = replaceElements(arr);
		//replaceElementsDontModifyArray(arr);
		for (int j = 0; j < num.length; j++) {
			System.out.print(num[j]);
		}
	}

	//solution for replace with first greatest element on right
	private static void replaceElementsDontModifyArray(int[] arr) {
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (!stk.isEmpty() && arr[i] > stk.peek()) {
				while (!stk.isEmpty()) {
					int j = stk.pop();
					System.out.println(j +"-->"+arr[i]);
				}
				stk.push(arr[i]);
			}else{
				stk.push(arr[i]);
			}
		}
		while(!stk.isEmpty()){
			System.out.println(stk.pop()+"-->"+-1);
		}
	}

	// 18, 6, 6, 6, 1, -1
	private static int[] replaceElements(int[] arr) {
		int n = arr.length;
		int max = -1;
		for (int i = n - 1; i >= 0; i--) {//temp = 17,max = 18
			int temp = arr[i];
			arr[i] = max;
			max = Math.max(max, temp);
		}
		return arr;
	}

}
