import java.util.*;
import java.lang.*;
import java.io.*;

public class AddTwoNumbers{

  public static void main(String[] args){
    int num1[] = {5,4,9};
    int num2[] = {5,6,4};
    ListNode head1 = createLinkedList(num1);
    ListNode head2 = createLinkedList(num2);
    ListNode head = addTwoNumbers(head1,head2);
    while(head!=null){
        System.out.println(head.val);
        head = head.next;
    }
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   if(l1==null){
     return l2;
   }
   if(l2==null){
     return l1;
   }
   int carry = 0;
   ListNode head = new ListNode(-1);
   ListNode node = head;
   while(l1!=null || l2!=null){
     int tot = carry;
     if(l1!=null){
       tot+= l1.val;
       l1 = l1.next;
     }
     if(l2!=null){
       tot+= l2.val;
       l2 = l2.next;
     }
    node.next = new ListNode(tot%10);
    carry = tot/10;
    node = node.next;
   }
   if(carry!=0){
     node.next = new ListNode(carry);
     node = node.next;
   }
   node.next = null;
   return head.next;
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
