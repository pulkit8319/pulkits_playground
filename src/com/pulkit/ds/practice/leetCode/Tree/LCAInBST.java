package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
public class LCAInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		/*root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);*/

		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(7);
		TreeNode node = lowestCommonAncestorIterative(root, p, null);
		System.out.println(node.val);
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		int parentVal = root.val;
		int pval = p.val;
		int qval = q.val;
		if (pval < parentVal && qval < parentVal) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (pval > parentVal && qval > parentVal) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
	
	private static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		int pval = p.val;
		int qval = q.val;
		while(root!=null){
			int parentVal = root.val;
			if(pval<parentVal && qval<parentVal){
				root=root.left;
			}else if(pval>parentVal && qval>parentVal){
				root = root.right;
			}else{
				return root;
			}
		}
		return null;
	}
}
