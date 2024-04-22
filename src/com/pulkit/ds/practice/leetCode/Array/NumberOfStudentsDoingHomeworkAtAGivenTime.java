package com.pulkit.ds.practice.leetCode.Array;

//Given two integer arrays startTime and endTime and given an integer queryTime.
//The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
//Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
public class NumberOfStudentsDoingHomeworkAtAGivenTime {

	public static void main(String[] args) {
		int[] startTime = {1,2,3}, endTime = {3,2,7};
		int queryTime = 4;
		int num = busyStudent(startTime,endTime,queryTime);
		System.out.println(num);
	}

	private static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int count = 0;
		for (int i = 0; i < endTime.length; i++) {
			if(queryTime>=startTime[i] && queryTime<=endTime[i]){
				count++;
			}
		}
		return count;
	}

}
