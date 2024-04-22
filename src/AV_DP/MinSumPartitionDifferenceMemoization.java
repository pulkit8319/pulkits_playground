import java.util.*;

public class MinSumPartitionDifferenceMemoization{

  public static void main(String[] args){
    int N = 2;
    int arr[] = {1, 4};
    System.out.println(minDifference(arr,N));
  }

  private static int minDifference(int arr[], int n)
  	{
        int sum = 0;
  	    for(int i=0;i<n;i++){
          sum+=arr[i];
        }
        int mid = 0;
        if(sum%2!=0){
          mid = sum/2 +1;
        }else{
          mid = sum/2;
        }
        int j = 0;
        for(j = mid;j>0;j--){

          boolean canSum = subsetSum(arr,n,j);
          if(canSum){
            break;
          }
        }
        return Math.abs(sum - 2*j);
  	}

    private static boolean subsetSum(int arr[], int n, int sum){
      Boolean memo[][] = new Boolean[n+1][sum+1];
      return subsetSum(arr, n,sum, memo);
    }

    private static boolean subsetSum(int arr[], int n, int sum, Boolean memo[][]){
      if(memo[n][sum]!=null){
        return memo[n][sum];
      }
      if(sum==0){
        return true;
      }
      if(n==0){
        return false;
      }
      if(arr[n-1]<=sum){
        memo[n][sum] = subsetSum(arr,n-1,sum-arr[n-1],memo) || subsetSum(arr, n-1, sum,memo);
      }else{
        memo[n][sum] =  subsetSum(arr,n-1,sum,memo);
      }
      return memo[n][sum];
    }

}
