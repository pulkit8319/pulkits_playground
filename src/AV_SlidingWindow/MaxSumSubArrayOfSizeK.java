import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxSumSubArrayOfSizeK{

  public static void main(String[] args){
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(100, 200, 300, 400));
    int k = 4;
    System.out.println(maximumSumSubarray(k,arr,arr.size()));
  }

    private static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        if(N<K){
          return 0;
        }
        long maxSum = 0;
        long sum = 0;
        int i=0;
        int j=0;
        while(j<N){
          sum+=Arr.get(j);
          if(j-i+1<K){
            j++;
          }else if(j-i+1==K){
            maxSum = Math.max(maxSum, sum);
            sum-=Arr.get(i);
            i++;
            j++;
          }
        }
        return maxSum;
    }

}
