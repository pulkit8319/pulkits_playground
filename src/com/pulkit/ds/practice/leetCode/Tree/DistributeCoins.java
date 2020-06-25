package com.pulkit.ds.practice.leetCode.Tree;

//Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
//In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
//Return the number of moves required to make every node have exactly one coin.
public class DistributeCoins {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		int moves = distributeCoins(root);
		System.out.println(moves);
	}

	private static int distributeCoins(TreeNode root) {
		distributeCoins1(root);
		return ans;
	}

	static int ans = 0;

	private static int distributeCoins1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = distributeCoins1(root.left);
		int r = distributeCoins1(root.right);
		ans += Math.abs(l) + Math.abs(r);
		return root.val + l + r - 1;
	}

}
