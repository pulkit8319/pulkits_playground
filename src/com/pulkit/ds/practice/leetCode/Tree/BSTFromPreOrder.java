package com.pulkit.ds.practice.leetCode.Tree;

//Return the root node of a binary search tree that matches the given preorder traversal.
public class BSTFromPreOrder {

	public static void main(String[] args) {
		int[] preorder = {8,5,1,7,10,12};
		TreeNode node = bstFromPreorder(preorder);
		node.inOrder(node);
	}

	static int index = 0;
	private static TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private static TreeNode bstFromPreorder(int[] preorder, int minValue, int maxValue) {
		if(index>=preorder.length){
			return null;
		}
		int val = preorder[index];
		if(val<minValue || val>maxValue){
			return null;
		}
		TreeNode node = new TreeNode(val);
		index++;
		node.left = bstFromPreorder(preorder,minValue,val);
		node.right = bstFromPreorder(preorder,val,maxValue);
		return node;
	}

}
