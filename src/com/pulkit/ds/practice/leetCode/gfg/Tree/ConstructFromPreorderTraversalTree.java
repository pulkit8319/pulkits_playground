package com.pulkit.ds.practice.leetCode.gfg.Tree;

public class ConstructFromPreorderTraversalTree {

	public static void main(String[] args) {
		int pre[] = { 10, 30, 20, 5, 15 };
		char preLN[] = { 'N', 'N', 'L', 'L', 'L' };
		Node root = constructTree(pre.length, pre, preLN);
		root.inorder(root);
	}

	static int index = 0;

	private static Node constructTree(int n, int[] pre, char[] preLN) {
		if (index >= n) {
			return null;
		}
		Node node = new Node(pre[index]);
		if(preLN[index++]=='N'){
			node.left = constructTree(n, pre, preLN);
			node.right = constructTree(n, pre, preLN);
		}
		return node;
	}

}
