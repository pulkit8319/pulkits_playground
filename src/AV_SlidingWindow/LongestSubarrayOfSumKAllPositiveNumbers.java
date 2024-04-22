import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestSubarrayOfSumKAllPositiveNumbers{

  public static void main(String[] args){
    int[] A = {1, 2, 3};
    int k = 6;
    System.out.println(lenOfLongSubarr(A,A.length,k));
  }

  private static int lenOfLongSubarr(int A[], int N, int K) {
    int sum = 0;
    int i=0,j=0;
    int ans=0;
    while(j<N){
      if(sum<K){
        sum+=A[j];
      }
       if(sum==K){
        ans = Math.max(ans,j-i+1);
        sum-=A[i];
        i++;
      }
       if(sum>K){
        while(sum>K){
          sum-=A[i];
          i++;
        }
      }
      j++;
    }
    return ans;
  }

}
