import java.util.*;

public class SubsetSumMemoization{

  public static void main(String[] args){
    int N = 6;
    int arr[] = {3, 34, 4, 12, 5, 2};
    int sum = 9;
    System.out.println(isSubsetSum(N,arr,sum));
  }

  private static Boolean isSubsetSum(int N, int arr[], int sum){
    boolean memo[][] = new boolean[N+1][sum+1];
    return isSubsetSum(N,arr,sum,memo);
    }

    private static Boolean isSubsetSum(int N, int arr[], int sum, boolean memo[][]){
      if(memo[N][sum]==true){
        return true;
      }
      if(sum==0){
        return true;
      }
      if(N==0){
        return false;
      }
      if(arr[N-1]<=sum){
        memo[N][sum] =  isSubsetSum(N-1, arr, sum-arr[N-1]) || isSubsetSum(N-1, arr, sum);
        return memo[N][sum];
      }else{
        memo[N][sum] = isSubsetSum(N-1, arr, sum);
        return memo[N][sum];
      }
      }
}
