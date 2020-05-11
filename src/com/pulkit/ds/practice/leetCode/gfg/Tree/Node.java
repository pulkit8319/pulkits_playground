package com.pulkit.ds.practice.gfg.Tree;

public class Node {

	int data;
	Node left,right = null;
	
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
