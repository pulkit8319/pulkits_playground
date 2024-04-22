import java.util.*;
import java.lang.*;
import java.io.*;

public class FloorOfAnElementInSortedArray{

  public static void main(String[] args){
    long arr[] = {70, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83};
    int n = 13;
    int x = 89;
    System.out.println(findFloor(arr,n,x));
  }

  private static int findFloor(long arr[], int n, long x)
    {
      int ans = -1;
      int start = 0,end = n-1;
      while(start<=end){
        int mid = start + (end-start)/2;
        if(arr[mid]==x){
          return mid;
        }else if(arr[mid]<x){
          ans = mid;
          start = mid+1;
        }else if(arr[mid]>x){
          end =  mid-1;
        }
      }
      return ans;
    }

}
