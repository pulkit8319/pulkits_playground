import java.util.*;
import java.lang.*;
import java.io.*;

public class CeilOfAnElementInSortedArray{

  public static void main(String[] args){
    long arr[] = {70, 72, 73, 77, 78, 82, 83};
    int n = 7;
    int x = 67;
    System.out.println(findCeil(arr,n,x));
  }

  private static int findCeil(long arr[], int n, long x)
    {
      int ans = -1;
      int start = 0;
      int end = n-1;
      while(start<=end){
        int mid = start+(end-start)/2;
        if(arr[mid]==x){
          return mid;
        }else if(arr[mid]>x){
          ans = mid;
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return ans;
    }

}
