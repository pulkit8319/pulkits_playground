import java.util.*;
import java.lang.*;
import java.io.*;

public class SumOfElementsBetweenK1AndK2Elements{

  public static void main(String[] args){
    long arr[] = {17,28};
    long K1 = 1, K2 = 2;
    long n = 2;
    System.out.println(sumBetweenTwoKthWay2(arr,n,K1,K2));
  }

  private static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
      long sum = 0;
      PriorityQueue<Long> pq = new PriorityQueue<Long>(Comparator.reverseOrder());
      for(int i=0;i<N;i++){
        pq.add(A[i]);
        if(pq.size()>K2-1){
          pq.poll();
        }
      }
      while(pq.size()>K1){
        sum+=pq.poll();
      }
      return sum;
    }

    private static long sumBetweenTwoKthWay2(long A[], long N, long K1, long K2)
      {
        long K1ThSmallest = kThSmallest(A,K1);
        long K2ThSmallest = kThSmallest(A,K2);
        long sum = 0;
        for(int i=0;i<N;i++){
          if(A[i]>K1ThSmallest && A[i]<K2ThSmallest){
            sum+=A[i];
          }
        }
        return sum;
      }

      private static long kThSmallest(long arr[], long k){
        PriorityQueue<Long> pq = new PriorityQueue<Long>(Comparator.reverseOrder());
        for(int i=0;i<arr.length;i++){
          pq.add(arr[i]);
          if(pq.size()>k){
            pq.poll();
          }
        }
        return pq.poll();
      }


}
