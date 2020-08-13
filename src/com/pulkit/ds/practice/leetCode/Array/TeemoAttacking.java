package com.pulkit.ds.practice.leetCode.Array;

//In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.
//You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
public class TeemoAttacking {

	public static void main(String[] args) {
		int timeSeries[] = {1,2};
		int time = findPoisonedDuration(timeSeries,2);
		System.out.println(time);
	}

	private static int findPoisonedDuration(int[] timeSeries, int duration) {
		int time = 0;
		int n = timeSeries.length;
		if(n==0){
			return time;
		}
		for (int i = 0; i < n-1; i++) {
			time+=Math.min(timeSeries[i+1]-timeSeries[i], duration);
		}
		return time+duration;
	}

}
