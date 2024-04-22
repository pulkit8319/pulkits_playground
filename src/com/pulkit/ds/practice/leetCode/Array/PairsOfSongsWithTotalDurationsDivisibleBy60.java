package com.pulkit.ds.practice.leetCode.Array;

//In a list of songs, the i-th song has a duration of time[i] seconds. 
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		int time[] = {418,204,77,278,239,457,284,263,372,279,476,416,360,18};
		int num = numPairsDivisibleBy60(time);
		System.out.println(num);
	}

	private static int numPairsDivisibleBy60(int[] time) {
		int count = 0;
		int c[] = new int[60];
		for (int i = 0; i < time.length; i++) {
			count+=c[(60-time[i]%60)%60];
			c[time[i]%60]++;
		}
		return count;
	}

}
