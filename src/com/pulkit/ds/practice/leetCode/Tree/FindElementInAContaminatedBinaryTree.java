package com.pulkit.ds.practice.leetCode.Tree;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

//Given a binary tree with the following rules:
//root.val == 0
//If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
//If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
//Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
//You need to first recover the binary tree and then implement the FindElements class:
//FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
//bool find(int target) Return if the target value exists in the recovered binary tree.
public class FindElementInAContaminatedBinaryTree {
	static Set<Integer> set = new HashSet<>();
	static BitSet set1 = new BitSet();
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		root.right = new TreeNode(-1);
		root.right.right = new TreeNode(-1);
		
		FindElements(root);
		root.inOrder(root);
		System.out.println(find(6));
	}

	private static void FindElements(TreeNode root) {
		FindElements(root,0);
	}

	private static void FindElements(TreeNode root, int i) {
		if(root==null){
			return;
		}
		root.val = i;
		set1.set(root.val);
		FindElements(root.left,i*2+1);
		FindElements(root.right,i*2+2);
	}
	
	private static boolean find(int target){
		return set1.get(target);
	}

	
}
