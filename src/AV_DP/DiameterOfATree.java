import java.util.*;

public class DiameterOfATree{

  public static void main(String[] args){
    Node root1 = new Node(1);
		root1.left = new Node(2);
    root1.right = new Node(3);
    	root1.left.left = new Node(23);
      	root1.left.right = new Node(21);
    System.out.println(diameter(root1));
  }

static Integer maxDia = Integer.MIN_VALUE;
  private static int diameter(Node root) {
    height(root);
    return maxDia;
  }

  private static int height(Node root) {
    if(root==null){
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    int temp = 1 + Math.max(left,right);
    maxDia = Math.max(maxDia, 1 + left+ right);
    return temp;
  }

}
