import java.util.*;
import java.lang.*;
import java.io.*;

public class FindStartingPointOfLoopInLL{

  public static void main(String[] args){
    int list[] = {1,2,3,4,2,1};
    ListNode head = createLinkedList(list);
    System.out.println(detectCycle(head));
    }

    private static ListNode detectCycle(ListNode head) {
      if(head==null || head.next==null){
        return null;
      }
      ListNode slow = head;
      ListNode fast = head;
      while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast==slow){
          slow = head;
          while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
          }
          return slow;
        }
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
