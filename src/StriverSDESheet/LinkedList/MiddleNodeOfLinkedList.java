import java.util.*;
import java.lang.*;
import java.io.*;

public class MiddleNodeOfLinkedList{

  public static void main(String[] args){
    int head[] = {1,2,3,4,5,6};
    ListNode node = new ListNode(head[0]);
    ListNode head1 = node;
    for(int i=1;i<head.length;i++){
      node.next = new ListNode(head[i]);
      node = node.next;
    }
    node.next = null;
    System.out.println(middleNode(head1).val);
  }

  private static ListNode middleNode(ListNode head) {
    ListNode nodeSlow = head,nodeFast = head;
    while(nodeFast!=null && nodeFast.next!=null){
      nodeSlow = nodeSlow.next;
      nodeFast = nodeFast.next.next;
    }
    return nodeSlow;
  }

}
