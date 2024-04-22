package com.pulkit.ds.practice;

import java.util.Scanner;

public class ProblemY {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (true) {
			int noOfSushiRolls = scan.nextInt();
			if (noOfSushiRolls == 0) {
				break;
			}
			numberOfInvites(noOfSushiRolls);
		}
		scan.close();
	}

	private static void numberOfInvites(int noOfSushiRolls) {
		int noOfInvites = 2;
		while (noOfSushiRolls % noOfInvites != 0) {
			noOfInvites++;
			if (noOfSushiRolls / 2 < noOfInvites) {
				System.out.println("No solution");
				return;
			}
		}
		System.out.println(noOfInvites - 1);
	}

}
