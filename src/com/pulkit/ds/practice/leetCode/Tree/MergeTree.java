package com.pulkit.ds.practice.leetCode.Tree;

//Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
//You need to merge them into a new binary tree.The merge rule is that if two nodes overlap,then sum node values up as the new value of the merged node.Otherwise,the NOT null node will be used as the node of new tree.
public class MergeTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.left = new TreeNode(4);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);

		TreeNode node  = mergeTreesIterative(p, q);
		node.inOrder(node);
	}

	private static TreeNode mergeTreesIterative(TreeNode t1, TreeNode t2) {
		
		return null;
	}

	private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null){
			return t2;
		}
		if(t2==null){
			return t1;
		}
		t1.val+=t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	private static TreeNode mergeTreesToNewTree(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null){
			return null;
		}
		TreeNode node;
		if(t1==null){
			node = new TreeNode(t2.val);
			node.left = mergeTreesToNewTree(t1, t2.left);
			node.right = mergeTreesToNewTree(t1, t2.right);
		}
		else if(t2==null){
			node = new TreeNode(t1.val);
			node.left = mergeTreesToNewTree(t1.left, t2);
			node.right = mergeTreesToNewTree(t1.right, t2);
		}else{
			node = new TreeNode(t1.val+t2.val);
			node.left = mergeTreesToNewTree(t1.left, t2.left);
			node.right = mergeTreesToNewTree(t1.right, t2.right);
		}
		return node;
	}

}
