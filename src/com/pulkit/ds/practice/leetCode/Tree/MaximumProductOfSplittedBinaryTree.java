package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;
import java.util.Map;

//Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
//Since the answer may be too large, return it modulo 10^9 + 7.

public class MaximumProductOfSplittedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(6);

		int maxPdt = maxProduct(root);
		System.out.println(maxPdt);
	}

	static long maxPdt = 0;
	
	//recursive normal
	 public int maxProduct1(TreeNode root) {
			
			if (root == null) {
				return 0;
			}
			long sumofNodes = sum(root,0);
			sum(root,sumofNodes);
			return (int)(maxPdt % (int)(1e9 + 7));
		
	    }
	  private long sum(TreeNode root,long sumofNodes) {
			if (root == null) {
				return 0;
			}
			long sum = root.val + sum(root.left,sumofNodes) + sum(root.right,sumofNodes);
			maxPdt = Math.max((sumofNodes - sum) * sum, maxPdt);
			return sum;
		}

	//Using hashmap
	private static int maxProduct(TreeNode root) {
		long maxPdt = 0;
		if (root == null) {
			return 0;
		}
		Map<TreeNode, Long> leftSumMap = new HashMap<>();
		Map<TreeNode, Long> rightSumMap = new HashMap<>();
		long sumofNodes = sum(root, leftSumMap,rightSumMap);
		for (TreeNode node : leftSumMap.keySet()) {
			long leftSum = leftSumMap.get(node);
			long rightSum = rightSumMap.get(node);
			maxPdt = Math.max(maxPdt, (sumofNodes - leftSum) * leftSum);
			maxPdt = Math.max(maxPdt, (sumofNodes - rightSum) * rightSum);
		}
		return (int) (maxPdt % (int) (1e9 + 7));
	}

	private static long sum(TreeNode root, Map<TreeNode, Long> leftSumMap, Map<TreeNode, Long> rightSumMap) {
		if (root == null) {
			return 0;
		}
		long subTree_left = sum(root.left, leftSumMap,rightSumMap);
		leftSumMap.put(root, subTree_left);
		long subTree_Right = sum(root.right, leftSumMap,rightSumMap);
		rightSumMap.put(root, subTree_Right);
		return root.val + subTree_left + subTree_Right;
	}

}
