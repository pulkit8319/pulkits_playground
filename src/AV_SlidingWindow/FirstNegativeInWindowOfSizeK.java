import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNegativeInWindowOfSizeK{

  public static void main(String[] args){
    long arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
    int k = 3;
    long[] ans = printFirstNegativeInteger(arr,arr.length,k);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]);
    }
  }

  private static long[] printFirstNegativeInteger(long A[], int N, int K)
  {
    long[] ans = new long[N-K+1];
    Queue<Long> q = new LinkedList<Long>();
    int i=0,j=0;
    int l = 0;
    while(j<N){
      if(A[j]<0){
        q.add(A[j]);
      }
      if(j-i+1<K){
        j++;
      }else if(j-i+1==K){
        if(!q.isEmpty()){
          ans[l++] = q.peek();
        }else{
          ans[l++] = 0;
        }
        if(!q.isEmpty() && q.peek()==A[i]){
          q.remove();
        }
        i++;
        j++;
      }
    }
    return ans;
  }

}
