import java.util.*;

public class EqualSumPartitionMemoization{

  public static void main(String[] args){
    int N = 4;
    int arr[] = {1, 3,5,3};
    System.out.println(equalPartition(N,arr));
  }

  static int equalPartition(int N, int arr[])
    {
      int sum = 0;
      for(int i=0;i<N;i++){
        sum+=arr[i];
      }
      if(sum%2==0){
        int memo[][] = new int[N+1][sum+1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
        return equalPartition(N,arr,sum/2,memo);
      }else{
        return 0;
      }
    }

    static int equalPartition(int N, int arr[],int sum,int memo[][])
      {
        if(memo[N][sum]!=-1){
          return memo[N][sum];
        }
        if(sum==0){
          return 1;
        }
        if(N==0){
          return 0;
        }
        if(arr[N-1]<=sum){
          memo[N][sum] =  Math.max(equalPartition(N-1,arr,sum-arr[N-1],memo),equalPartition(N-1,arr,sum,memo));
          return memo[N][sum];
        }else{
          memo[N][sum] =  equalPartition(N-1,arr,sum,memo);
          return memo[N][sum];
        }
      }
}
