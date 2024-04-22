package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
//Each node of each tree in the answer must have node.val = 0.
//You may return the final list of trees in any order.
public class AllPossibleBinaryTrees {

	public static void main(String[] args) {
		List<TreeNode> list = allPossibleFBT(7);
		System.out.println(list);
	}

	private static List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> list = new ArrayList<>();
		if (N == 1) {
			TreeNode node = new TreeNode(0);
			list.add(node);
			return list;
		}
		N=N-1;
		for (int i = 1; i < N; i = i + 2) {
			List<TreeNode> lefts = allPossibleFBT(i);
			List<TreeNode> rights = allPossibleFBT(N - i);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode root = new TreeNode(0);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		return list;
	}

}
