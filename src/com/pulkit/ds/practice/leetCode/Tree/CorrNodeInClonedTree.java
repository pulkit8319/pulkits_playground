package com.pulkit.ds.practice.leetCode.Tree;

//Given two binary trees original and cloned and given a reference to a node target in the original tree.
//The cloned tree is a copy of the original tree.
//Return a reference to the same node in the cloned tree.
//Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
//Follow up:Solve the problem if repeated values on the tree are allowed.
public class CorrNodeInClonedTree {

	public static void main(String[] args) {
		TreeNode original = new TreeNode(1);
		original.left = new TreeNode(1);
		original.right = new TreeNode(2);
		original.right.left = new TreeNode(2);

		TreeNode cloned = new TreeNode(1);

		TreeNode target = new TreeNode(1);
		TreeNode node = getTargetCopy(original, cloned, target);
		System.out.print(node.val);
	}

	private static TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
		if (cloned == null || target == null) {
			return null;
		}
		if (cloned.val == target.val) {
			return cloned;
		}
		TreeNode node = getTargetCopy(original, cloned.left, target);
		return null != node ? node : getTargetCopy(original, cloned.right, target);
	}

}
