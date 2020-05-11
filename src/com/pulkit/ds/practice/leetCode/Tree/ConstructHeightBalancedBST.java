package com.pulkit.ds.practice.leetCode.Tree;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1

public class ConstructHeightBalancedBST {

	public static void main(String[] args) {
		int arr[] = { -10, -3, 0, 5, 9 };
		TreeNode root = sortedArrayToBST(arr);
		
		 System.out.print(root.val+" " +root.left.val+" " +root.right.val);
		 System.out.print(root.left.right.val+" " +root.right.right.val);
		 
		//root.inOrder(root);
	}

	private static TreeNode sortedArrayToBST(int[] nums) {
		int size = nums.length;
		return constructBST(nums, 0, size - 1);
	}

	private static TreeNode constructBST(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end ) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = constructBST(nums, start, mid - 1);
		node.right = constructBST(nums, mid + 1, end);
		return node;
	}

}
