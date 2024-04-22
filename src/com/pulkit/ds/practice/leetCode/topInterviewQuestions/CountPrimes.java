package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

public class CountPrimes {

	public static void main(String[] args) {
		int count = countPrimes(10);
		System.out.println(count);
	}

	//called - Sieve of Eratosthenes
	private static int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i< n; i++) {
			if (!notPrime[i]) {
				count++;
			}
			for (int j = 2; j * i < n; j++) {
				notPrime[i * j] = true;
			}
		}
		return count;
	}

}
