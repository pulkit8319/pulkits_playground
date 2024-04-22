package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

public class IsPowerOfThree {
	
	public static void main(String[] args) {
		boolean b = isPowerOfThree(27);
		System.out.println(b);
	}

	private static boolean isPowerOfThree(int n) {
		if(n==1){
			return true;
		}
		if(n%3==0){
			return isPowerOfThree(n/3);
		}else{
			return false;
		}
	}

}
