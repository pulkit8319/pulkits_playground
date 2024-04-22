import java.util.*;

public class EqualSumPartitionTopDown{

  public static void main(String[] args){
    int N = 8;
    int arr[] = {478, 757, 314, 471, 729, 100, 459, 618};
    System.out.println(equalPartition(N,arr));
  }

  static int equalPartition(int N, int arr[])
    {
      int sum = 0;
      for(int i=0;i<N;i++){
        sum+=arr[i];
      }
      if(sum%2==0){
        sum = sum/2;
        int t[][] = new int[N+1][sum+1];
        for(int i=0;i<N+1;i++){
          for(int j=0;j<sum+1;j++){
            if(i==0){
              t[i][j]=0;
            }
            if(j==0){
              t[i][j]=1;
            }
          }
        }
        for(int i=1;i<N+1;i++){
          for(int j=1;j<sum+1;j++){
            if(arr[i-1]<=j){
              t[i][j] =  Math.max(t[i-1][j-arr[i-1]],t[i-1][j]);
            }else{
              t[i][j] =  t[i-1][j];
            }
          }
        }
        return t[N][sum];
      }else{
        return 0;
      }
    }

}
