import java.util.*;
import java.lang.*;
import java.io.*;

public class StockSpanProblem{

  public static void main(String[] args){
    int arr[] = {10, 4, 5, 90, 120, 80};
    int n = 6;
    int[] ans = calculateSpanUsingNextGreaterElementIndex(arr,n);
    for(int i=0;i<n;i++){
      System.out.println(ans[i]);
    }
  }

  private static int[] calculateSpan(int price[], int n)
    {
      Stack<Pair> stk = new Stack<>();
      int[] ans = new int[n];
      for(int i=0;i<n;i++){
        int count = 1;
        while(!stk.isEmpty() && price[i]>=stk.peek().num){
          Pair p = stk.pop();
          count+=p.span;
        }
        ans[i] = count;
        stk.push(new Pair(count,price[i]));
      }
      return ans;
    }

    private static int[] calculateSpanUsingNextGreaterElementIndex(int price[], int n)
      {
        Stack<Integer> stk = new Stack<>();
        int[] ans  = new int[n];
        for(int i=0;i<n;i++){
          while(!stk.isEmpty() && price[stk.peek()]<=price[i]){
            stk.pop();
          }
          ans[i] = stk.isEmpty()? i+1:i-stk.peek();
          stk.push(i);
        }
        return ans;
      }
}

class Pair{
  int span;
  int num;
  public Pair(int span, int num){
    this.span = span;
    this.num = num;
  }
}
