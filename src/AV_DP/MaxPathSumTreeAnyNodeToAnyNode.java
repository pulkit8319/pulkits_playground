import java.util.*;

public class MaxPathSumTreeAnyNodeToAnyNode{

  public static void main(String[] args){
    Node root1 = new Node(10);
		root1.left = new Node(2);
    root1.right = new Node(5);
  //  root1.left.left = new Node(20);
    //root1.left.right = new Node(1);
    //root1.right.left = new Node(3);
    root1.right.right = new Node(-1);
    System.out.println(findMaxSum(root1));
  }

  static int max = Integer.MIN_VALUE;
  private static int findMaxSum(Node node)
      {
        findMax(node);
        return max;
      }

  private static int findMax(Node node)
      {
        if(node==null){
          return 0;
        }
        int left = Math.max(findMax(node.left),0);
        int right = Math.max(findMax(node.right),0);
        max = Math.max(max, left + right + node.data);
        return Math.max(left, right) +node.data;
      }
}
