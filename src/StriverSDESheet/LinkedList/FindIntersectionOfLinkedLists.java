import java.util.*;
import java.lang.*;
import java.io.*;

public class FindIntersectionOfLinkedLists{

  public static void main(String[] args){
    int listA[] = {4,1,8,4,5};
    int listB[] = {5,6,1,8,4,5};
    ListNode headA = createLinkedList(listA);
    ListNode headB = createLinkedList(listB);
    System.out.println(getIntersectionNode(headA,headB).val);
    }

  private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode nodeA = headA;
      ListNode nodeB = headB;
      int lengthA=0,lengthB=0;
      while(nodeA!=null){
        nodeA = nodeA.next;
        lengthA++;
      }
      while(nodeB!=null){
        lengthB++;
        nodeB = nodeB.next;
      }
      nodeA = headA;
      nodeB = headB;
      int diff = Math.abs(lengthA-lengthB);
      while(diff>0){
        if(lengthA>lengthB){
          nodeA = nodeA.next;
        }else{
          nodeB = nodeB.next;
        }
      }
      while(nodeA!=null && nodeB!=null){
        if(nodeA==nodeB){
          return nodeA;
        }
        nodeA = nodeA.next;
        nodeB = nodeB.next;
      }
      return null;
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
