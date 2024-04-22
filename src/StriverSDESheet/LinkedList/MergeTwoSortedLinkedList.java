import java.util.*;
import java.lang.*;
import java.io.*;

//Linked List
public class MergeTwoSortedLinkedList{

  public static void main(String[] args){
    int list1[] = {1,2,4};
    int list2[] = {1,3,4};
    ListNode node1 = new ListNode(list1[0]);
    ListNode node2 = new ListNode(list2[0]);
    ListNode head1 = node1;
    for(int i=1;i<list1.length;i++){
      node1.next = new ListNode(list1[i]);
      node1 = node1.next;
    }
    node1.next = null;
    ListNode head2 = node2;
    for(int i=1;i<list2.length;i++){
      node2.next = new ListNode(list2[i]);
      node2 = node2.next;
    }
    node2.next = null;
    ListNode n  = mergeTwoLists(head1,head2);
    while(n!=null){
      System.out.println(n.val);
      n = n.next;
    }
  }

  private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1==null){
      return list2;
    }
    if(list2==null){
      return list1;
    }
    ListNode head;
    if(list1.val>list2.val){
      head = list2;
      list2 = list2.next;
    }else{
      head = list1;
      list1 = list1.next;
    }
    ListNode node = head;
    while(list1!=null && list2!=null){
      if(list1.val>list2.val){
        node.next = list2;
        list2 = list2.next;
      }else{
        node.next = list1;
        list1 = list1.next;
      }
      node = node.next;
    }
    if(list1!=null){
      node.next = list1;
    }
    if(list2!=null){
      node.next = list2;
    }
    return head;
  }

}
