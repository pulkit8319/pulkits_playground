package com.pulkit.ds.practice.leetCode.Array;

//A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
//The bus goes along both directions i.e. clockwise and counterclockwise.
//Return the shortest distance between the given start and destination stops.
public class DistanceBetweenBusStops {

	public static void main(String[] args) {
		int distance[] = { 1, 2, 3, 4 };
		int minDistance = distanceBetweenBusStops(distance, 1, 0);
		System.out.println(minDistance);
	}

	private static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int tot = 0;
		int n = distance.length;
		int clkwiseDistance = 0;
		for (int i = 0; i < n; i++) {
			tot += distance[i];
		}
		if (start > destination) {
			int temp = start;
			start = destination;
			destination = temp;
		}
		for (int i = start; i < destination; i++) {
			clkwiseDistance += distance[i];
		}
		return Math.min(clkwiseDistance, tot - clkwiseDistance);
	}

}
