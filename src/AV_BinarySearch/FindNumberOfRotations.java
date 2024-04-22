import java.util.*;
import java.lang.*;
import java.io.*;

public class FindNumberOfRotations{

  public static void main(String[] args){
    int arr[] = { 66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60};
    int n = 13;
    System.out.println(findKRotation(arr,n));
  }

  private static int findKRotation(int arr[], int n) {
      if(n==0 || n==1){
        return 0;
      }
      int start = 0,end = n-1;
      while(start<=end){
        int mid = start + (end-start)/2;
        int next = (mid+1)%n;
        int prev = (mid+n-1)%n;
        if(arr[prev]>arr[mid] && arr[mid]<arr[next]){
          return mid;
        }else if(arr[mid]<arr[end]){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return 0;
    }
}
