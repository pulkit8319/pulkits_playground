import java.util.*;
import java.lang.*;
import java.io.*;

public class FindIndexOfFirstOneInInfiniteSortedArray{

  public static void main(String[] args){
    long arr[] = {0,0,0,0,0,0,1,1,1,1,1,1,1,};
    System.out.println(findElement(arr));
  }

  private static int findElement(long arr[])
    {
      int start = 0;
      int end = 1;
      while(arr[end]!=1){
        start = end;
        end = 2*end;
      }
      int index = -1;
      while(start<=end){
        int mid = start+(end-start)/2;
        if(arr[mid]==1){
          index = mid;
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return index;
    }

}
