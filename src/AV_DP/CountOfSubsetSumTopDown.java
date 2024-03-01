import java.util.*;

public class CountOfSubsetSumTopDown{

  public static void main(String[] args){
    int N = 9;
    int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 1};
    int sum = 1;
    System.out.println(perfectSum(arr,N,sum));
  }

  private static int perfectSum(int arr[],int n, int sum)
  {
    int mod =1000000007;
      int t[][] = new int[n+1][sum+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<sum+1;j++){
          if(i==0){
            if(j==0){
              t[i][j]=1;
            }else{
              t[i][j]=0;
            }
          }
          if(i==1 && j==0){
            if(arr[i-1]==0){
              t[i][j] = 2;
            }else{
              t[i][j] = 1;
            }
          }
        }
      }
        for(int i=1;i<n+1;i++){
          for(int j=0;j<sum+1;j++){
            if(arr[i-1]<=j){
              t[i][j] = (t[i-1][j-arr[i-1]] + t[i-1][j])%mod;
            }else{
              t[i][j]=t[i-1][j]%mod;
            }
          }
        }
      return t[n][sum]%mod;
  }

}
