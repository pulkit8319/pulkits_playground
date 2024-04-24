import java.util.*;
import java.lang.*;
import java.io.*;

public class IsPalindrome{

  public static void main(String[] args){
    int list[] = {1,2,3,4,2,1};
    ListNode head = createLinkedList(list);
    System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
      if(head==null || head.next==null){
        return true;
      }
      ListNode slow = head;
      ListNode fast = head.next;
      //Reach mid
      while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
      }
      //reverse from slow.next
      ListNode newHead = reverseLL(slow.next);
      ListNode node = newHead;
      while(newHead!=null){
        if(head.val != newHead.val){
          return false;
        }
        newHead = newHead.next;
        head = head.next;
      }
      //reverse LL again
      reverseLL(newHead);
      return true;
    }

    private static ListNode reverseLL(ListNode head){
      if(head==null || head.next==null){
        return head;
      }
      ListNode node = reverseLL(head.next);
      head.next.next = head;
      head.next = null;
      return node;
    }

  private static ListNode createLinkedList(int[] num) {
    ListNode node = new ListNode(num[0]);
    ListNode head = node;
    for(int i=1;i<num.length;i++){
      node.next = new ListNode(num[i]);
      node = node.next;
    }
    node.next = null;
    return head;
  }

}
