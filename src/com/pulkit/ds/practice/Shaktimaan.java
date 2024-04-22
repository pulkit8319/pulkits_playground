package com.pulkit.ds.practice;

public class Shaktimaan {
	public static void main(String[] args) {
		int[] arr = { -5, 4, -2, 3, 1, -1, -6, -1, 0, -5 };
		int minPower = getMinPower(arr);
		System.out.println(minPower);
	}

	private static int getMinPower(int[] arr) {
		int totalPower = 0;
		int minPower = 0;
		for (int i = 0; i < arr.length; i++) {
			totalPower = totalPower + arr[i];
			if (totalPower <= 0) {
				minPower = minPower + Math.abs(totalPower) + 1;//6
				totalPower = 1;
			}
		}
		return minPower;
	}
}
