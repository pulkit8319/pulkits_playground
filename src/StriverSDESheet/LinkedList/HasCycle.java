import java.util.*;
import java.lang.*;
import java.io.*;

public class HasCycle{

  public static void main(String[] args){
    int listA[] = {4,1,8,4,5};
    int listB[] = {5,6,1,8,4,5};
    ListNode headA = createLinkedList(listA);
    ListNode headB = createLinkedList(listB);
    System.out.println(hasCycle(headA);
    }

    private static boolean hasCycle(ListNode head) {
        ListNode nodeSlow = head;
        ListNode nodeFast = head;
        while(nodeFast!=null && nodeFast.next!=null ){
          nodeSlow = nodeSlow.next;
          nodeFast = nodeFast.next.next;
          if(nodeSlow==nodeFast){
            return true;
          }
        }
        return false;
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
