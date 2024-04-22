import java.util.*;
import java.lang.*;
import java.io.*;

public class ReverseALinkedList{

  public static void main(String[] args){
    int head[] = {1,2,3,4,5};
    ListNode node = new ListNode(head[0]);
    ListNode head1 = node;
    for(int i=1;i<head.length;i++){
      node.next = new ListNode(head[i]);
      node = node.next;
    }
    node.next = null;
    ListNode head2 = reverseListRecursive(head1);
    while(head2!=null){
        System.out.println(head2.val);
        head2 = head2.next;
    }
  }

  private static ListNode reverseListIterative(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }
    ListNode next = null;
    ListNode prev = null;
    while(head!=null){
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  private static ListNode reverseListRecursive(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }
    ListNode n = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return n;
  }

}
