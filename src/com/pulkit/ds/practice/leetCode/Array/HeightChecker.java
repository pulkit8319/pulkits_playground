package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;

//Students are asked to stand in non-decreasing order of heights for an annual photo.
//Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
//Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
public class HeightChecker {

	public static void main(String[] args) {
		int heights[] = {1,1,4,2,1,3};
		int moves = heightChecker(heights);
		System.out.println(moves);
	}

	private static int heightChecker(int[] heights) {
		int newArr[] = heights.clone();
		int moves = 0;
		Arrays.sort(newArr);
		for (int i = 0; i < newArr.length; i++) {
			if(newArr[i]!=heights[i]){
				moves++;
			}
		}
		return moves;
	}

}
