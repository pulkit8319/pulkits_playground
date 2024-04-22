import java.util.*;
import java.lang.*;
import java.io.*;

public class NextGreaterElementToRight{

  public static void main(String[] args){
    long arr[] = {1};
    int n = 1;
    long[] ans = nextLargerElement(arr,n);
    for(int i=0;i<n;i++){
      System.out.println(ans[i]);
    }
  }

  private static long[] nextLargerElement(long[] arr, int n)
    {
      long[] ans = new long[n];
      Stack<Long> stk = new Stack<>();
      for(int i=n-1;i>=0;i--){
        while(!stk.isEmpty() && arr[i]>=stk.peek()){
          stk.pop();
        }
        if(stk.isEmpty()){
          ans[i] = -1;
        }else{
          ans[i] = stk.peek();
        }
        stk.push(arr[i]);
      }
      return ans;
    }
}
