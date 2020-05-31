package com.pulkit.ds.practice.leetCode.gfg.Tree;

public class Node {

	int data;
	public Node left,right,next = null;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void inorder(Node node){
		if(node==null){
			return;
		}
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
}
