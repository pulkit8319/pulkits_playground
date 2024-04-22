package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
public class AverageOfLevels {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Double> list = averageOfLevels(root);
		System.out.println(list);
	}

	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<Double>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			Double sum = 0d;
			for (int i = size; i > 0; i--) {
				TreeNode node = q.poll();
				sum +=node.val;
				if(node.left!=null){
					q.offer(node.left);
				}
				if(node.right!=null){
					q.offer(node.right);
				}
			}
			list.add((double)sum/size);
		}
		return list;
	}

}
