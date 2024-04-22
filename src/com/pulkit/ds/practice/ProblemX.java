package com.pulkit.ds.practice;

import java.util.Scanner;

public class ProblemX {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (true) {
			String movieSchedule = scan.nextLine();
			if (movieSchedule.equals("O")) {
				break;
			}
			getBoringDays(movieSchedule);
		}
		scan.close();
	}

	private static void getBoringDays(String movieSchedule) {
		int boringDays = 0;
		for (int i = 1; i < movieSchedule.length(); i++) {
			if (movieSchedule.charAt(i) == movieSchedule.charAt(i - 1)) {
				boringDays++;
			}
		}
		System.out.println(boringDays);
	}
}
