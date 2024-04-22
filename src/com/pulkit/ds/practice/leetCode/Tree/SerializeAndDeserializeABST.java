package com.pulkit.ds.practice.leetCode.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
//The encoded string should be as compact as possible.
//Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
public class SerializeAndDeserializeABST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(22);
		String serialize = serialize1(root);
		System.out.println(serialize);
		TreeNode deserialize = deserialize1(serialize);
		deserialize.inOrder(deserialize);
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			inOrder(sb, root);
			preOrder(sb, root);
		}
		return sb.toString();
	}

	static int preIndex = 0;

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if(data.isEmpty()){
			return null;
		}
		String[] strArr = data.split("--");
		int[] inOrder = Arrays.stream(strArr[0].split("-")).mapToInt(Integer::parseInt).toArray();
		int[] preOrder = Arrays.stream(strArr[1].split("-")).mapToInt(Integer::parseInt).toArray();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		return buildTree(0, inOrder.length - 1, preOrder, inOrder, map);
	}

	private static TreeNode buildTree(int start, int end, int[] preOrder, int[] inOrder, Map<Integer, Integer> map) {
		if (start > end) {
			return null;
		}
		int val = preOrder[preIndex++];
		TreeNode root = new TreeNode(val);
		if (start == end) {
			return root;
		}
		Integer index = map.get(val);
		root.left = buildTree(start, index - 1, preOrder, inOrder, map);
		root.right = buildTree(index + 1, end, preOrder, inOrder, map);
		return root;
	}

	private static void preOrder(StringBuilder sb, TreeNode root) {
		if (root == null) {
			return;
		}
		sb.append("-" + root.val);
		preOrder(sb, root.left);
		preOrder(sb, root.right);
	}

	private static void inOrder(StringBuilder sb, TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(sb, root.left);
		sb.append(root.val + "-");
		inOrder(sb, root.right);
	}

	//###############################Simple Use Of PreOrder################
	
	 // Encodes a tree to a single string.
    public static String serialize1(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	if(root!=null){
    		preOrder(sb, root);
    	}
    	System.out.println(sb.toString());
    	return sb.toString();
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize1(String data) {
    	if(data==null){
    		return null;
    	}
    	Queue<String> q = new LinkedList<>(Arrays.asList(data.split("-")));
    	q.poll();
    	return deserialize(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

	private static TreeNode deserialize(Queue<String> q, int minValue, int maxValue) {
		if(q.isEmpty()){
			return null;
		}
		int val = Integer.valueOf(q.peek());
		if(val<minValue || val > maxValue){
			return null;
		}
		q.poll();
		TreeNode root = new TreeNode(val);
		root.left = deserialize(q,minValue,val);
		root.right = deserialize(q,val,maxValue);
		return root;
	}
}
