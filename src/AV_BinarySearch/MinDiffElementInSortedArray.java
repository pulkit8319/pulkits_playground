import java.util.*;
import java.lang.*;
import java.io.*;

public class MinDiffElementInSortedArray{

  public static void main(String[] args){
    int arr[] = {4,6,10,13};
    int x = 12;
    System.out.println(minDiffElementOptimizedAV(arr,x));
  }

  private static int minDiffElement(int arr[], int x)
    {
      int start = 0;
      int end = arr.length-1;
      int floor = -1;
      int ceil = -1;
      int indexFloor = -1;
      //Find floor
      while(start<=end){
        int mid = start+(end-start)/2;
        if(arr[mid]>x){
          end = mid-1;
        }else if(arr[mid]<x){
          floor = arr[mid];
          indexFloor = mid;
          start = mid+1;
        }else{
          return 0;
        }
      }
      if(indexFloor!=arr.length-1){
        ceil = arr[indexFloor+1];
      }
      if(ceil==-1){
        return x-floor;
      }
      return Math.min(x-floor, ceil-x);
    }

//most optimized.
    private static int minDiffElementOptimizedAV(int arr[], int x)
      {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
          int mid = start + (end-start)/2;
          if(arr[mid]==x){
            return 0;
          }else if(arr[mid]>x){
            end = mid-1;
          }else{
            start = mid+1;
          }
        }
        return Math.min(arr[start]-x,x-arr[end]);
      }

}
