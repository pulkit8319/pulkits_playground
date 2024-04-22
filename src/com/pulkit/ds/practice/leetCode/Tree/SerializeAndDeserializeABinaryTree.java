package com.pulkit.ds.practice.leetCode.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
public class SerializeAndDeserializeABinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		String serialize = serialize(root);
		System.out.println(serialize);
		TreeNode deserialize = deserialize(serialize);
		deserialize.inOrder(deserialize);
	}

	private static TreeNode deserialize(String data) {
		if (!data.isEmpty()) {
			Queue<String> q = new LinkedList<>();
			q.addAll(Arrays.asList(data.split(",")));
			return buildTree(q);
		}
		return null;
	}

	private static TreeNode buildTree(Queue<String> q) {
		String val = q.poll();
		if(val.equals("#")){
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = buildTree(q);
		node.right = buildTree(q);
		return node;
	}

	private static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			preOrder(sb, root);
		}
		return sb.toString();
	}

	private static void preOrder(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		preOrder(sb, root.left);
		preOrder(sb, root.right);
	}

}
