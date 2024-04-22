import java.util.*;
import java.lang.*;
import java.io.*;

public class NextGreaterElementToLeft{

  public static void main(String[] args){
    long arr[] = {1,3,2,4};
    int n = 4;
    long[] ans = nextLargerElement(arr,n);
    for(int i=0;i<n;i++){
      System.out.println(ans[i]);
    }
  }

  private static long[] nextLargerElement(long[] arr,int n){
    Stack<Long> stk = new Stack<>();
    long[] ans = new long[n];
    for(int i=0;i<n;i++){
      while(!stk.isEmpty() && arr[i]>=stk.peek()){
        stk.pop();
      }
      if(stk.isEmpty()){
        ans[i] = -1;
      }else{
        ans[i] = stk.pop();
      }
      stk.push(arr[i]);
    }
    return ans;
  }


}
