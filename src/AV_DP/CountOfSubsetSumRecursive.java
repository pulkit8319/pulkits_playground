import java.util.*;

public class CountOfSubsetSumRecursive{

  public static void main(String[] args){
    int N = 4;
    int arr[] = {1,1,1,1};
    int sum = 2;
    System.out.println(perfectSum(arr,N,sum));
  }

  private static int perfectSum(int arr[],int n, int sum)
  {
    int count = 0;
    return perfectSum(arr,n,sum,count);
  }

  private static int perfectSum(int arr[],int n, int sum, int count)
  {
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
      count = perfectSum(arr,n-1,sum-arr[n-1],count) + perfectSum(arr,n-1,sum,count);
    }else{
      count = perfectSum(arr,n-1,sum,count);
    }
    return count;
  }
}
