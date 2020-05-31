package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		int n = 3;

		List<TreeNode> list = generateTrees(n);
		System.out.println(list);
		for(TreeNode node:list){
			node.inOrder(node);
		}
	}

	private static List<TreeNode> generateTrees(int n) {
		if(n==0){
			return new ArrayList<>();
		}
		return generateTrees(1, n);
	}

	private static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(start>end){
			list.add(null);	
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftNodes = generateTrees(start, i - 1);
			List<TreeNode> rightNodes = generateTrees(i + 1, end);
			for (TreeNode leftNode : leftNodes) {
				for (TreeNode rightNode : rightNodes) {
					TreeNode node = new TreeNode(i);
					node.left = leftNode;
					node.right = rightNode;
					list.add(node);
				}
			}
		}
		return list;
	}

}
