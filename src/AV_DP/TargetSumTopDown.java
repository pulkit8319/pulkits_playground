import java.util.*;

public class TargetSumTopDown{

  public static void main(String[] args){
    int[] nums = {1};
    int  target = 1;
    System.out.println(findTargetSumWays(nums,target));
  }

    private static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;
        for(int i=0;i<n;i++){
            totSum+=nums[i];
        }
        int sum = totSum+target;
        if(sum<0 || sum%2!=0){
          return 0;
        }
        sum = sum/2;
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
          for(int j=0;j<sum+1;j++){
            if(i==0){
              if(j==0){
                t[i][j] = 1;
              }else{
                t[i][j] = 0;
              }
            }
            if(i==1 && j==0){
              if(nums[i-1]==0){
                t[i][j] = 2;
              }else{
                t[i][j] = 1;
              }
            }
          }
        }
            for(int i=1;i<n+1;i++){
              for(int j=0;j<sum+1;j++){
                if(nums[i-1]<=j){
                  t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                }else{
                  t[i][j] = t[i-1][j];
                }
              }
          }
          return t[n][sum];
        }

}
