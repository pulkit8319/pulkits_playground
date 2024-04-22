package com.pulkit.ds.practice.leetCode.gfg.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNodeLevelTree {

	public static void main(String[] args) {
			Node root = new Node(2);
			root.left = new Node(1);
			root.right = new Node(3);
			root.left.left = new Node(4);
			root.left.right = new Node(6);
			root.right.right = new Node(8);
			root.left.right.left = new Node(5);
			int maxNodeLevel = maxNodeLevel(root);
			//root.inorder(root);
			System.out.println(maxNodeLevel);
	}

	private static int maxNodeLevel(Node node) {   
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		int count=0,level=0,maxLevel=-1;
		while(!queue.isEmpty()){
			int size = queue.size();
			if(size>count){
				count = size;
				maxLevel = level;
			}
			while(size!=0){
				Node nNode = queue.poll();
				if(nNode.left!=null){
					queue.add(nNode.left);
				}
				if(nNode.right!=null){
					queue.add(nNode.right);
				}
				size--;
			}
			level++;
		}
		return maxLevel;
	}

}
