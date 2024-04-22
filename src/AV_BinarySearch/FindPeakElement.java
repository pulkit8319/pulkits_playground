import java.util.*;
import java.lang.*;
import java.io.*;

public class FindPeakElement{

  public static void main(String[] args){
    int nums[] = { 1,2,3,2};
    System.out.println(findPeakElement(nums));
  }

  private static int findPeakElement(int[] nums) {
    int n = nums.length;
    if(n==1){
      return 0;
    }
    int start = 0;
    int end = nums.length-1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(mid>0 && mid<n-1){
        if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
          return mid;
        }else if(nums[mid-1]>nums[mid]){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }else if(mid==0){
        if(nums[0]>nums[1]){
          return 0;
        }else{
          return 1;
        }
      }else if(mid==n-1){
        if(nums[n-1]>nums[n-2]){
          return n-1;
        }else{
          return n-2;
        }
      }
    }
    return -1;
  }
}
