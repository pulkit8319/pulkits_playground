package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//In an infinite binary tree where every node has two children, the nodes are labelled in row order.
//In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
public class PathInZigZagLabelledBinaryTree {

	public static void main(String[] args) {
		List<Integer> list = pathInZigZagTreeIterative(14);
		System.out.println(list);
	}

	private static List<Integer> pathInZigZagTreeIterative(int label) {
		List<Integer> list = new ArrayList<Integer>();
		int sum = 1;
		int level = 0;
		while (sum < label) {
			level += 1;
			sum += Math.pow(2, level);
		}
		while (level >= 0) {
			list.add(label);
			int num = (int) Math.pow(2, level);
			label = (sum + num - label) / 2;
			sum = sum - num;
			level--;
		}
		Collections.reverse(list);
		return list;
	}

	static List<Integer> list = new ArrayList<Integer>();

	private static List<Integer> pathInZigZagTree(int label) {
		if (label > 0) {
			list.add(label);
			pathInZigZagTree(0, 0, label);
		}
		Collections.reverse(list);
		return list;
	}

	private static int pathInZigZagTree(int level, int sum, int label) {
		int num = (int) Math.pow(2, level);
		sum += num;
		if (sum < label) {
			label = pathInZigZagTree(level + 1, sum, label);
			list.add(label);
		}
		return (sum + num - label) / 2;

	}

}
