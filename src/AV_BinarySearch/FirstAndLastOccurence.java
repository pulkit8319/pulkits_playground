import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstAndLastOccurence{

  public static void main(String[] args){
    long arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
    int N = 9;
    long x = 1;
    pair p = indexes(arr,x);
    System.out.println(p.first+"   "+p.second);
  }

  private static pair indexes(long v[], long x)
    {
      int start = 0;
      int end = v.length-1;
      int first = -1;
      int last = -1;
      //find first occurence
      while(start<=end){
        int mid = start + (end-start)/2;
        if(v[mid]==x){
          first =mid;
          end = mid-1;
        }else if(v[mid]>x){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      if(first==-1){
        return new pair(-1,-1);
      }
      //find last occurence
      start = 0;
      end = v.length-1;
      while(start<=end){
        int mid = start + (end-start)/2;
        if(v[mid]==x){
          last = mid;
          start = mid+1;
        }else if(v[mid]>x){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return new pair(first,last);
    }

}

class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
