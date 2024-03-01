import java.util.*;

public class PartitionsWithGivenDifferenceMemoization{

  static int countOfPartitions = 0;

  public static void main(String[] args){
    int N = 4;
    int arr[] = { 1,1,1,1};
    int d = 0;
    System.out.println(countPartitions(N,d,arr));
  }

  public static int countPartitions(int n, int d, int arr[]){
    int sum = 0;
    for(int i=0;i<n;i++){
      sum+=arr[i];
    }
    int partialSum =(sum - d)/2;
    int memo[][] = new int[n+1][sum+1];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
    return countSubsetSum(n,partialSum,arr, memo);
   }

     public static int countSubsetSum(int n, int sum,int arr[], int memo[][]){
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
         }else{
           return 1;
         }
       }
       if(arr[n-1]<=sum){
         memo[n][sum] = countSubsetSum(n-1,sum-arr[n-1],arr,memo) + countSubsetSum(n-1,sum,arr,memo);
       }else{
         memo[n][sum] = countSubsetSum(n-1,sum,arr,memo);
       }
       return memo[n][sum];
     }
}
