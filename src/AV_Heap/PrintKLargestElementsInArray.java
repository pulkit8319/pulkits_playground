import java.util.*;
import java.lang.*;
import java.io.*;

public class PrintKLargestElementsInArray{

  public static void main(String[] args){
    int arr[] = {12, 5, 787, 1, 23};
    int n = 5;
    int k = 2;
    System.out.println(kLargest(arr,n,k));
  }

  private static int[] kLargest(int[] arr, int n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for(int i=0;i<n;i++){
      pq.add(arr[i]);
      if(pq.size()>k){
        pq.poll();
      }
    }
    int ans[] = new int[k];
    while(k>0){
      ans[k-1] = pq.poll();
      k--;
    }
    return ans;
  }

}
