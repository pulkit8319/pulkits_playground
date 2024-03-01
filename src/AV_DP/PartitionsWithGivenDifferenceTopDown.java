import java.util.*;

public class PartitionsWithGivenDifferenceTopDown{

  static int countOfPartitions = 0;

  public static void main(String[] args){
    int N = 17;
    int arr[] = { 2, 40, 6, 6, 43, 44, 10, 32, 12, 12, 26, 31, 48, 14, 38, 42, 25};
    int d = 2;
    System.out.println(countPartitions(N,d,arr));
  }

  public static int countPartitions(int n, int d, int arr[]){
    int mod =1000000007;
    int sum = 0;
    for(int i=0;i<n;i++){
      sum+=arr[i];
    }
    if((sum - d)%2!=0){
      return 0;
    }
    int partialSum =(sum - d)/2;
    int t[][] = new int[n+1][partialSum+1];
    for(int i=0;i<n+1;i++){
      for(int j=0;j<partialSum+1;j++){
        if(i==0){
          if(j==0){
            t[i][j] = 1;
          }else{
            t[i][j] = 0;
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
      for(int j=0;j<partialSum+1;j++){
        if(arr[i-1]<=j){
          t[i][j] = (t[i-1][j-arr[i-1]] + t[i-1][j])%mod;
        }else{
          t[i][j] = t[i-1][j]%mod;
        }
      }
    }
    return t[n][partialSum]%mod;
   }


}
