import java.util.*;

public class SubsetSumRecursive{

  public static void main(String[] args){
    int N = 4;
    int arr[] = {1,1,1,1};
    int sum = 2;
    System.out.println(isSubsetSum(N,arr,sum));
  }

  private static Boolean isSubsetSum(int N, int arr[], int sum){
        if(sum==0){
          return true;
        }
        if(N==0){
          return false;
        }
        if(arr[N-1]<=sum){
          return isSubsetSum(N-1, arr, sum-arr[N-1]) || isSubsetSum(N-1, arr, sum);
        }else{
          return isSubsetSum(N-1, arr, sum);
        }
    }
}
