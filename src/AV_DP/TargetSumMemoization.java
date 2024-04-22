import java.util.*;

public class TargetSumMemoization{

  public static void main(String[] args){
    int[] nums = {100};
    int  target = -200;
    System.out.println(findTargetSumWays(nums,target));
  }

    private static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;
        for(int i=0;i<nums.length;i++){
          totSum+=nums[i];
        }
        if(totSum+target<0 || (totSum+target)%2!=0){
          return 0;
        }
        int sum = (totSum+target)/2;
        int memo[][] = new int[n+1][sum+1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
        return findTargetSumWays(n,nums,sum,memo);
    }

    private static int findTargetSumWays(int n, int[] nums, int sum, int memo[][]) {
        if(memo[n][sum]!=-1){
          return memo[n][sum];
        }
        if(n==0){
          if(sum==0){
            return 1;
          }else{
            return 0;
          }
        }
        if(n==1 && sum==0){
          if(nums[n-1]==0){
            return 2;
          }else{
            return 1;
          }
        }
        if(nums[n-1]<=sum){
          memo[n][sum] =  findTargetSumWays(n-1, nums, sum - nums[n-1],memo) + findTargetSumWays(n-1, nums, sum ,memo);
        }else{
          memo[n][sum] =  findTargetSumWays(n-1, nums, sum,memo);
        }
        return memo[n][sum];
    }
}
