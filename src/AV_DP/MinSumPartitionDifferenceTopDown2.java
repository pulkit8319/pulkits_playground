import java.util.*;

//More efficient way. Complexity - n*(sum of elements)
public class MinSumPartitionDifferenceTopDown2{

  public static void main(String[] args){
    int N = 8;
    int arr[] = {5, 6, 6, 5, 7, 4, 7, 6};
    System.out.println(minDifference(arr,N));
  }

  private static int minDifference(int arr[], int n)
  	{
        int sum = 0;
  	    for(int i=0;i<n;i++){
          sum+=arr[i];
        }
        boolean t[][] = subsetSum(n,sum,arr);
        int minDiff = Integer.MAX_VALUE;
        for(int j=0;j<sum/2+1;j++){
          if(t[n][j]){
            if(sum - 2*j<minDiff){
              minDiff = sum-2*j;
            }
          }
        }
        return minDiff;
    }

    private static boolean[][] subsetSum(int n, int sum, int arr[]){
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
            t[i][j] = t[i-1][j];
          }
        }
      }
      return t;
    }

}
