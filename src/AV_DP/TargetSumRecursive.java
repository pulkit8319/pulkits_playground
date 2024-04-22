import java.util.*;

//Same as PartitionWithGivenDifference
public class TargetSumRecursive{

  public static void main(String[] args){
    int[] nums = {1,1,1,1,1};
    int  target = 3;
    System.out.println(findTargetSumWays(nums,target));
  }

    private static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;
        for(int i=0;i<n;i++){
          totSum+=nums[i];
        }
        if((totSum+target)%2!=0){
          return 0;
        }
        int sum = (totSum+target)/2;
        return findTargetSumWays(n,nums,sum);
    }

    private static int findTargetSumWays(int n, int[] nums, int sum) {
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
        return findTargetSumWays(n-1,nums,sum-nums[n-1]) + findTargetSumWays(n-1, nums,sum);
      }else{
        return findTargetSumWays(n-1, nums,sum);
      }
    }
}
