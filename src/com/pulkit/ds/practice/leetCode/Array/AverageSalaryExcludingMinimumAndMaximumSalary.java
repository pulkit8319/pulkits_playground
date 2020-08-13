package com.pulkit.ds.practice.leetCode.Array;

//Given an array of unique integers salary where salary[i] is the salary of the employee i.
//Return the average salary of employees excluding the minimum and maximum salary.
public class AverageSalaryExcludingMinimumAndMaximumSalary {

	public static void main(String[] args) {
		int[] salary = { 4000, 3000, 1000, 2000 };
		double d = average(salary);
		//System.out.print(d);
		System.out.println(1>>1);//01
	}

	private static double average(int[] salary) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < salary.length; i++) {
			sum+=salary[i];
			max = Math.max(max, salary[i]);
			min = Math.min(min, salary[i]);
		}
		return (double)(sum-max-min)/(salary.length-2);
	}

}
