import java.util.*;
import java.lang.*;
import java.io.*;

public class DeleteNthNodeFromBack{

  public static void main(String[] args){
    int head[] = {1};
    ListNode node = new ListNode(head[0]);
    ListNode head1 = node;
    for(int i=1;i<head.length;i++){
      node.next = new ListNode(head[i]);
      node = node.next;
    }
    node.next = null;
    ListNode head2 = removeNthFromEnd(head1,2);
    while(head2!=null){
        System.out.println(head2.val);
        head2 = head2.next;
    }
  }

  private static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;
    while(n!=0){
      fast = fast.next;
      n--;
    }
    if(fast==null){
      return head.next;
    }
    while(fast.next!=null){
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }

}
