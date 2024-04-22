import java.util.*;
import java.lang.*;
import java.io.*;

public class FindKthSmallestElement{

  public static void main(String[] args){
    int arr[] = {7, 10, 4, 3, 20, 15};
    int n = 6;
    int k = 3;
    System.out.println(kthSmallest(arr,0,n-1,k));
  }

  private static int kthSmallest(int[] arr, int l, int r, int k)
  {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    for(;l<=r;l++){
      pq.add(arr[l]);
      if(pq.size()>k){
        pq.poll();
      }
    }
    return pq.peek();'
  }

}
