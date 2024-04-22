import java.util.*;
import java.lang.*;
import java.io.*;

public class FindElementInBitonicArray{

  public static void main(String[] args){
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
    int n = 12;
    System.out.println(solve(arr,n));
  }

  private static int solve(int[] A, int B) {
    //find peak
    int n = A.length;
    int start = 0,end = n-1;
    int peakIndex = -1;
    int elementIndex = -1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
        peakIndex = mid;
        break;
      }else if(A[mid]<A[mid-1]){
        end = mid-1;
      }else{
        start = mid+1;
      }
    }
    if(B>A[peakIndex]){
      return -1;
    }
    if(A[0]<=B && B<=A[peakIndex]){
      elementIndex = binarySearch(A,B,0,peakIndex);
    }
    if(elementIndex==-1){
      elementIndex = binarySearchReverse(A,B,peakIndex+1,n-1);
    }
    return elementIndex;
    }

    private static int binarySearch(int[] A,int B, int start, int end){
      while(start<=end){
        int mid = start+(end-start)/2;
        if(A[mid]==B){
          return mid;
        }else if(A[mid]>B){
          end =mid-1;
        }else{
          start = mid+1;
        }
      }
      return -1;
    }

    private static int binarySearchReverse(int[] A,int B, int start, int end){
      while(start<=end){
        int mid = start+(end-start)/2;
        if(A[mid]==B){
          return mid;
        }else if(A[mid]>B){
          start = mid+1;
        }else{
          end = mid-1;
        }
      }
      return -1;
    }

}
