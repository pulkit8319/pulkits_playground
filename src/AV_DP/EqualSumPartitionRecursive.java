import java.util.*;

public class EqualSumPartitionRecursive{

  public static void main(String[] args){
    int N = 3;
    int arr[] = {1, 3,5};
    System.out.println(equalPartition(N,arr));
  }

  static int equalPartition(int N, int arr[])
    {
      int sum = 0;
      for(int i=0;i<N;i++){
        sum+=arr[i];
      }
      if(sum%2==0){
        return equalPartition(N,arr,sum/2);
      }else{
        return 0;
      }
    }

    static int equalPartition(int N, int arr[],int sum)
      {
        if(sum==0){
          return 1;
        }
        if(N==0){
          return 0;
        }
        if(arr[N-1]<=sum){
          return Math.max(equalPartition(N-1,arr,sum-arr[N-1]),equalPartition(N-1,arr,sum));
        }else{
          return equalPartition(N-1,arr,sum);
        }
      }
}
