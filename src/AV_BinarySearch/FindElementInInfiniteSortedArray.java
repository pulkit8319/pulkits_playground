import java.util.*;
import java.lang.*;
import java.io.*;

public class FindElementInInfiniteSortedArray{

  public static void main(String[] args){
    long arr[] = {70, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83};
    int x = 81;
    System.out.println(findElement(arr,x));
  }

  private static int findElement(long arr[], long x)
    {
      int start = 0;
      int end = 1;
      while(arr[end]<x){
        start = end;
        end = 2*end;
      }
      while(start<=end){
        int mid = start+(end-start)/2;
        if(arr[mid]==x){
          return mid;
        }else if(arr[mid]<x){
          start = mid+1;
        }else{
          end = mid-1;
        }
      }
      return -1;
    }

}
