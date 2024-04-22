import java.util.*;
import java.lang.*;
import java.io.*;

public class NextSmallerElementToLeft{

  public static void main(String[] args){
    int arr[] = {1, 6, 2};
    int n = 3;
    List<Integer> ans = leftSmaller(n,arr);
    for(Integer i:ans){
      System.out.println(i);
    }
  }

  public static List<Integer> leftSmaller(int n, int a[])
    {
      Stack<Integer> stk = new Stack<>();
      List<Integer> list = new ArrayList<>();
      for(int i=0;i<n;i++){
        while(!stk.isEmpty() && stk.peek()>=a[i]){
          stk.pop();
        }
        if(stk.isEmpty()){
          list.add(-1);
        }else{
          list.add(stk.peek());
        }
        stk.push(a[i]);
      }
      return list;
    }
}
