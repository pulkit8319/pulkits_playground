package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;

public class SmallestSubTreeWithAllTheDeepestNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);

		TreeNode node = subtreeWithAllDeepest(root);
		System.out.println(node.val);
	}

	private static TreeNode subtreeWithAllDeepest(TreeNode root) {
		if(root==null){
			return null;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if(leftHeight==rightHeight){
			return root;
		}else if(leftHeight>rightHeight){
			return subtreeWithAllDeepest(root.left);
		}else{
			return subtreeWithAllDeepest(root.right);
		}
	}

	static HashMap<TreeNode, Integer> depthMap = new HashMap<>();
	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if(depthMap.containsKey(root)){
			return depthMap.get(root);
		}
		int max = Math.max(height(root.left), height(root.right)) + 1;
		depthMap.put(root, max);
		return max;
	}

}
