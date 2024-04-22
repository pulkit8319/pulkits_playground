import java.util.*;

public class MinSumPartitionDifferenceTopDown{

  public static void main(String[] args){
    int N = 4;
    int arr[] = {1, 6, 11, 5};
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
      boolean t[][] = new boolean[n+1][sum+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<sum+1;j++){
          if(i==0){
            t[i][j] = false;
          }
          if(j==0){
            t[i][j] = true;
          }
        }
      }
      for(int i=1;i<n+1;i++){
        for(int j=1;j<sum+1;j++){
          if(arr[i-1]<=j){
            t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
          }else{
            t[i][j] =  t[i-1][j];
          }
        }
      }
      return t[n][sum];
    }

}
