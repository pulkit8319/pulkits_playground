package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.List;

//Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
//For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
public class KidsWithGreatestNumberOfCandies {

	public static void main(String[] args) {
		int candies[] = { 2, 3, 5, 1, 3 };
		List<Boolean> list = kidsWithCandies(candies, 3);
		System.out.println(list);
	}

	private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> list = new ArrayList<Boolean>();
		int max = 0;
		for (int i = 0; i < candies.length; i++) {
			max = Math.max(max, candies[i]);
		}
		for (int i = 0; i < candies.length; i++) {
			list.add(candies[i] + extraCandies >= max ? true : false);
		}
		return list;
	}

}
