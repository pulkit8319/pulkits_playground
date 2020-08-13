package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		boolean b = isHappy(19);
		System.out.println(b);
	}

	private static boolean isHappy(int n) {
		int num = 0;
		Set<Integer> set = new HashSet<>();
		while (true) {
			num += (n % 10) * (n % 10);
			n = n / 10;
			if (n == 0) {
				if (num == 1) {
					return true;
				}
				if (set.contains(num)) {
					return false;
				}
				n = num;
				set.add(num);
				num = 0;
			}
		}
	}

}
