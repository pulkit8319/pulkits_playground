package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

public class FactorialTrailingZeros {

	public static void main(String[] args) {
		int count = trailingZeroes(1808548329);
		System.out.println(count);
	}

	private static int trailingZeroes(int n) {
		int zeroes = 0;
		while(n/5>0){
			n/=5;
			zeroes+=n;
		}
		return zeroes;
	}

	

}
