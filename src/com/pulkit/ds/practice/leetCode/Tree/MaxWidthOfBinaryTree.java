package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		int maxWidth = widthOfBinaryTreeIterative(root);
		System.out.println(maxWidth);
	}

	private static int widthOfBinaryTreeIterative(TreeNode root) {
		if(root==null){
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		HashMap<TreeNode,Integer> map = new HashMap<>();
		q.add(root);
		int maxWidth = 0;
		while(!q.isEmpty()){
			int size = q.size();
			int start = 0;
			int end = 0;
			for(int i=0;i<size;i++){
				TreeNode curr = q.poll();
				if(i==0){
					start = map.getOrDefault(curr,0);
				}
				if(i==size-1){
					end = map.getOrDefault(curr,0);
				}
				if(curr.left!=null){
					map.put(curr.left, 2*map.getOrDefault(curr,0));
					q.add(curr.left);
				}
				if(curr.right!=null){
					map.put(curr.right, 2*map.getOrDefault(curr,0)+1);
					q.add(curr.right);
				}
			}
			int currWidth = end-start+1;
			maxWidth = Math.max(maxWidth, currWidth);
		}
		return maxWidth;
	}

	static int ans = 0;

	private static int widthOfBinaryTree(TreeNode root) {
		Map<Integer, Integer> leftWidthMap = new HashMap<>();
		int depth = 0;
		int pos = 0;
		widthOfBinaryTree(root, leftWidthMap, depth, pos);
		return ans;
	}

	private static void widthOfBinaryTree(TreeNode root, Map<Integer, Integer> leftWidthMap, int depth, int pos) {
		if (root == null) {
			return;
		}
		if (!leftWidthMap.containsKey(depth)) {
			leftWidthMap.put(depth, pos);
		}
		ans = Math.max(ans, pos - leftWidthMap.get(depth) + 1);
		widthOfBinaryTree(root.left, leftWidthMap, depth + 1, 2 * pos);
		widthOfBinaryTree(root.right, leftWidthMap, depth + 1, 2 * pos + 1);
	}

}
