package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//Calling next() will return the next smallest number in the BST.


//Can be done using queue, arraylist, stack
public class BinarySearchTreeIterator {
	
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static List<Integer> list = new ArrayList<Integer>();
	
	static Stack<TreeNode> stk = new Stack<>();
	
	static int index;
	
	public BinarySearchTreeIterator(TreeNode root) {
		//pushAll(root);
		inorder(root);
		index = -1;
	}

	private void inorder(TreeNode root) {
		if(root==null){
			return;
		}
		//q.add(root.val);
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);
		System.out.println(iterator.next());    // return 3
		System.out.println(iterator.next());  // return 7
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next());    // return 9
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());   // return 15
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());    // return 20
		System.out.println(iterator.hasNext());
	}
	
	/** @return the next smallest number */
    public static int next() {
    	index++;
        return list.get(index);
    }
    
    /** @return whether we have a next smallest number */
    public static boolean hasNext() {
       if(index+1>=list.size()){
    	   return false;
       }
       return true;
    }
    
    //#################################Using Stack###########################################
    
    private static void pushAll(TreeNode root) {
		while(root!=null){
			stk.push(root);
			root = root.left;
		}
	}
    
    /** @return the next smallest number */
    public static int next1() {
        if(!stk.isEmpty()){
        	TreeNode curr = stk.pop();
        	pushAll(curr.right);
        	return curr.val;
        }
        return -1;
    }
    
    /** @return whether we have a next smallest number */
    public static boolean hasNext1() {
        return !stk.isEmpty();
    }



}
