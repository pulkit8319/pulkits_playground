package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.List;

//In a list of songs, the i-th song has a duration of time[i] seconds. 
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		int time[] = {30,20,150,100,40};
		int num = numPairsDivisibleBy60(time);
		System.out.println(num);
	}

	private static int numPairsDivisibleBy60(int[] time) {
		int count = 0;
		List<Float> list = new ArrayList<>();
		list.add(0.0f);
		for (int i = 0; i < time.length; i++) {
			float j = Math.abs(((float)time[i]/60) -1) ;
			if(list.contains(j)){
				count++;
			}else{
				list.add(j);
			}
			System.out.println(list);
		}
		return count;
	}

}
