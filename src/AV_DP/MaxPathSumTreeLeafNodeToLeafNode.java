import java.util.*;

public class MaxPathSumTreeLeafNodeToLeafNode{

  public static void main(String[] args){
    TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(6);
    root1.right = new TreeNode(2);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(3);
    root1.left.left.left = new TreeNode(9);
    root1.left.left.right = new TreeNode(7);
    System.out.println(findMaxSum(root1));
  }

  static int max = Integer.MIN_VALUE;
  private static int findMaxSum(TreeNode node)
      {
        if(node.left==null || node.right==null){
          return -1;
        }
        findMax(node);
        return max;
      }

  private static int findMax(TreeNode node)
      {
        if(node==null){
          return 0;
        }
        int left = findMax(node.left);
        int right = findMax(node.right);
        max = Math.max(max, left+right+node.val);
        return Math.max(left + node.val, right + node.val);
      }

}

class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

	}
