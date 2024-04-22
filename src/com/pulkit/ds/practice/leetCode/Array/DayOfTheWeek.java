package com.pulkit.ds.practice.leetCode.Array;

//Given a date, return the corresponding day of the week for that date.
//The input is given as three integers representing the day, month and year respectively.
//Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
public class DayOfTheWeek {

	public static void main(String[] args) {
		String day = dayOfTheWeek(18,7,1999);
		System.out.println(day);
	}

	private static String dayOfTheWeek(int day, int month, int year) {
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
		int i = java.time.Year.of(year).atMonth(month).atDay(day).getDayOfWeek().getValue()-1;
		return days[i];
	}

}
