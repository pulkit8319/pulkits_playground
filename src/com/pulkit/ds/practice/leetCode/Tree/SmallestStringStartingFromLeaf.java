package com.pulkit.ds.practice.leetCode.Tree;

//Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
//Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
public class SmallestStringStartingFromLeaf {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		String smallest = smallestFromLeaf(root);
		System.out.println(smallest);
	}

	static String ans = "~";
	private static String smallestFromLeaf(TreeNode root) {
		if(root!=null){
			smallestFromLeaf(root,"");
		}
		return ans;
	}
	private static void smallestFromLeaf(TreeNode root, String string) {
		string = (char)(97+root.val)+string;
		if(root.left==null && root.right==null){
			if(string.compareTo(ans)<0){
				ans = string;
			}
			return;
		}
		if(root.left!=null){
			smallestFromLeaf(root.left,string);
		}
		if(root.right!=null){
			smallestFromLeaf(root.right,string);
		}
	}

}
