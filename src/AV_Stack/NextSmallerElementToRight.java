import java.util.*;
import java.lang.*;
import java.io.*;

//Professor X wants his students to help each other in the chemistry lab.
//He suggests that every student should help out a classmate who scored less marks than him in chemistry
//and whose roll number appears after him. But the students are lazy and they don't want to search too far.
//They each pick the first roll number after them that fits the criteria. Find the marks of the classmate that each student picks.
//Note: one student may be selected by multiple classmates.
public class NextSmallerElementToRight{

  public static void main(String[] args){
    int arr[] = {3, 8, 5, 2, 25};
    int n = 5;
    int[] ans = help_classmate(arr,n);
    for(int i=0;i<n;i++){
      System.out.println(ans[i]);
    }
  }

  public static int[] help_classmate(int arr[], int n)
	{
    Stack<Integer> stk = new Stack<>();
    int ans[] = new int[n];
    for(int i=n-1;i>=0;i--){
        while(!stk.isEmpty() && stk.peek()>=arr[i]){
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
