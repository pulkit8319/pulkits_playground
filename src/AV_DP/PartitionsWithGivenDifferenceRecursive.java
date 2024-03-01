import java.util.*;

public class PartitionsWithGivenDifferenceRecursive{

  static int countOfPartitions = 0;

  public static void main(String[] args){
    int N = 4;
    int arr[] = { 5,2,6,4};
    int d = 3;
    System.out.println(countPartitions(N,d,arr));
  }

  public static int countPartitions(int n, int d, int arr[]){
    int sum = 0;
    for(int i=0;i<n;i++){
      sum+=arr[i];
    }
    int partialSum =(sum - d)/2;
    int count = 0;
    return countSubsetSum(n,partialSum,arr, count);
   }

     public static int countSubsetSum(int n, int sum,int arr[], int count){
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
           count = countSubsetSum(n-1,sum-arr[n-1],arr,count) + countSubsetSum(n-1,sum,arr,count);
         }else{
           count = countSubsetSum(n-1,sum,arr,count);
         }
         return count;
  }
}
