package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
public class MostFrequentSubtreeSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(3);

		int arr[] = findFrequentTreeSum(root);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	static int maxCount = 0;
	static Map<Integer, Integer> map = new HashMap<>();

	private static int[] findFrequentTreeSum(TreeNode root) {
		postOrder(root);
		List<Integer> list = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == maxCount) {
				list.add(key);
			}
		}
		System.out.println(map);
		int arr[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	private static int postOrder(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = postOrder(root.left);
		int right = postOrder(root.right);
		int sum = left + right + root.val;
		int count = map.getOrDefault(sum, 0) + 1;
		map.put(sum, count);
		maxCount = Math.max(count, maxCount);
		return sum;
	}

}
