import java.util.*;
import java.lang.*;
import java.io.*;

public class FindNumberInSortedRotatedArray{

  public static void main(String[] args){
    int arr[] = { 1,3};
    int n = 1;
    System.out.println(search(arr,n));
  }

  private static int search(int[] nums, int target) {
    if(nums.length==1){
      return nums[0]==target?0:-1;
    }
    int minValIndex = findMinValueIndex(nums);
    int start = 0;
    int end = nums.length-1;
    if(minValIndex==-1){
      return binarySearch(nums,start,end, target);
    }else if(target>=nums[minValIndex] && target<=nums[end]){
      return binarySearch(nums,minValIndex,end, target);
    }else{
      return binarySearch(nums, start, minValIndex-1, target);
    }
  }
  private static int findMinValueIndex(int[] nums) {
    int start = 0;
    int n = nums.length-1;
    int end = n;
    while(start<=end){
      int mid = start+(end-start)/2;
      int prev = (mid-1+n)%n;
      int next = (mid+1)%n;
      if(nums[prev]>nums[mid] && nums[next]>nums[mid]){
        return mid;
      }else if(nums[mid]<nums[end]){
        end = mid-1;
      }else{
        start = mid+1;
      }
    }
    return -1;
  }

  private static int binarySearch(int nums[], int start, int end, int target){
    while(start<=end){
      int mid = start +(end-start)/2;
      if(nums[mid]==target){
        return mid;
      }else if(target>nums[mid]){
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    return -1;
  }

}
