package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given two binary search trees root1 and root2.
//Return a list containing all the integers from both trees sorted in ascending order.
public class AllElementsInTwoBST {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(4);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(0);
		root2.right = new TreeNode(3);
		List<Integer> list = getAllElements(root1, root2);
		System.out.println(list);
	}

	private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		if (root1 != null) {
			inOrder(root1,list1);
		}
		if (root2 != null) {
			inOrder(root2,list2);
		}
		int l1 = list1.size();
		int l2 = list2.size();
		int i=0,j=0;
		while(i<l1 && j<l2){
			int e1 = list1.get(i);
			int e2 = list2.get(j);
			if(e1<e2){
				list3.add(e1);
				i++;
			}else if(e1>e2){
				list3.add(e2);
				j++;
			}else{
				list3.add(e1);
				list3.add(e2);
				i++;
				j++;
			}
		}
		while(i<l1){
			list3.add(list1.get(i));
			i++;
		}
		while(j<l2){
			list3.add(list2.get(j));
			j++;
		}
		return list3;
	}

	private static void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left,list);
		list.add(root.val);
		inOrder(root.right,list);
	}

}
