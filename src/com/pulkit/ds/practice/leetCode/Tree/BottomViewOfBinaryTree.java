package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
//In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
//Return the number of moves required to make every node have exactly one coin.
public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);
		root.right.right = new TreeNode(25);
		bottomView(root);
	}

	private static void bottomView(TreeNode root) {
		Map<Integer, Custom> map = new HashMap<>();
		print(map, 0, root, 0);
		Set<Integer> keySet = map.keySet();
		keySet.stream().sorted().forEach(c->System.out.println(map.get(c).getV()));
	}

	private static void print(Map<Integer, Custom> map, int i, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (map.containsKey(i)) {
			Custom c = map.get(i);
			if (c.getK() < level) {
				map.put(i, new Custom(level, root.val));
			}
		} else {
			map.put(i, new Custom(level, root.val));
		}
		print(map, i - 1, root.left, level + 1);
		print(map, i + 1, root.right, level + 1);
	}

}

class Custom {
	Integer k;
	Integer v;

	public Custom(Integer k, Integer v) {
		this.k = k;
		this.v = v;
	}

	public Integer getK() {
		return k;
	}

	public void setK(Integer k) {
		this.k = k;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}

}