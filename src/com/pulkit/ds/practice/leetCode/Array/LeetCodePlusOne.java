package com.pulkit.ds.practice.leetCode.Array;

/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.*/
public class LeetCodePlusOne {

	public static void main(String[] args) {
		int digits[] = {4,3,2,1};
		int digit1[] = plusOne(digits);
		for (int i = 0; i < digit1.length; i++) {
			System.out.println(digit1[i]);
		}
	}

	private static int[] plusOne(int[] digits) {
		for(int i=digits.length-1;i>=0;i--) {
			if(digits[i]==9) {
				digits[i] = 0;
			}else {
				digits[i]++;
				return digits;
			}
		}
		int digits1[] = new int[digits.length+1];
		digits1[0]=1;
		return digits1;
	}

}
