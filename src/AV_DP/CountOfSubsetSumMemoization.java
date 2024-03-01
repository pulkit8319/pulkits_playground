import java.util.*;

public class CountOfSubsetSumMemoization{

  public static void main(String[] args){
    int N = 9;
    int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 1};
    int sum = 1;
    System.out.println(perfectSum(arr,N,sum));
  }

  private static int perfectSum(int arr[],int n, int sum)
  {
    int memo[][] = new int[n+1][sum+1];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
    return perfectSum(arr,n,sum,memo);
  }

  private static int perfectSum(int arr[],int n, int sum, int memo[][])
  {
    if(memo[n][sum]!=-1){
      return memo[n][sum];
    }
    if(n==0){
      if(sum==0){
        return 1;
      }else{
        return 0;
      }
    }
    if(n==1 && sum==0){
      if(arr[n-1]==0){
        return 2;
      }else if(arr[n-1]>0){
        return 1;
      }
    }
    if(arr[n-1]<=sum){
      memo[n][sum] = perfectSum(arr,n-1,sum-arr[n-1],memo) + perfectSum(arr,n-1,sum,memo);
    }else{
      memo[n][sum] = perfectSum(arr,n-1,sum,memo);
    }
    return memo[n][sum];
  }
}
