import java.util.*;
import java.lang.*;
import java.io.*;

public class DeleteNodeInALinkedList{

  public static void main(String[] args){
    int head[] = {4,5,1,9};
    ListNode node = new ListNode(head[0]);
    ListNode head1 = node;
    ListNode toBeDeleted = new ListNode(-1);
    for(int i=1;i<head.length;i++){
      node.next = new ListNode(head[i]);
      if(node.val==5){
        toBeDeleted = node;
      }
      node = node.next;
    }
    node.next = null;
    deleteNode(toBeDeleted);
    while(head1!=null){
        System.out.println(head1.val);
        head1 = head1.next;
    }
  }

  private static void deleteNode(ListNode node) {
    ListNode tmp = node.next.next;
    node.val = node.next.val;
    node.next = tmp;
  }

}
