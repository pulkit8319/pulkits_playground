import java.util.*;
import java.lang.*;
import java.io.*;

public class FindMaxInBitonicArray{

  public static void main(String[] args){
    int nums[] = {1,15,25,45,42,21,17,12,11};
    System.out.println(findMaximum(nums,nums.length));
  }

  static int findMaximum(int[] arr, int n) {
    if(n==1){
      return arr[0];
    }
    int start = 0;
    int end = n-1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(mid>0 && mid<n-1){
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
          return arr[mid];
        }else if(arr[mid-1]>arr[mid]){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }else if(mid==0){
        if(arr[0]<arr[1]){
          return arr[1];
        }else{
          return arr[0];
        }
      }else if(mid==n-1){
        if(arr[n-2]>arr[n-1]){
          return arr[n-2];
        }else{
          return arr[n-1];
        }
      }
    }
    return -1;
  }
}
