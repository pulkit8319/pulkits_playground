import java.util.*;
import java.lang.*;
import java.io.*;

public class ConnectRopesMinimiseCost{

  public static void main(String[] args){
    long arr[] = {16};
    int n = 1;
    System.out.println(minCost(arr,n));
  }

  private static long minCost(long arr[], int n)
    {
      PriorityQueue<Long> pq = new PriorityQueue<Long>();
      for(int i=0;i<n;i++){
        pq.add(arr[i]);
      }
      long cost = 0;
      while(pq.size()>1){
        long l1 = pq.poll();
        long l2 = pq.poll();
        cost = cost + l1+l2;
        pq.add(l1+l2);
      }
      return cost;
    }
}
