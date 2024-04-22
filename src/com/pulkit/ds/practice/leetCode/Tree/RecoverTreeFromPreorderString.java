package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//We run a preorder depth first search on the root of a binary tree.
//At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
//If a node has only one child, that child is guaranteed to be the left child.
//Given the output S of this traversal, recover the tree and return its root.
public class RecoverTreeFromPreorderString {

	public static void main(String[] args) {
		String S = "1-2--3--4-5--6--7";
		TreeNode root = recoverFromPreorder(S);
		System.out.println(root);
	}

	private static TreeNode recoverFromPreorder(String S) {
		String[] token = S.split("-");
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(new TreeNode(Integer.parseInt(token[0])));
		int level = 1;
		for(int i=1;i<token.length;i++){
			if(!token[i].isEmpty()){
				TreeNode node = new TreeNode(Integer.parseInt(token[i]));
				list.add(level,node);
				TreeNode parent = list.get(level-1);
				if(parent.left==null){
					parent.left = node;
				}else{
					parent.right = node;
				}
				level = 1;
			}else{
				level++;
			}
		}
		return list.get(0);
	}

}
