import java.util.*;
import java.lang.*;
import java.io.*;

public class FindMaxOfAllSubArrays{

  public static void main(String[] args){
    int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
    int B = 3;
    int ans[] = slidingMaximum(A,B);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]);
    }
  }

  private static int[] slidingMaximum(final int[] A, int B) {
    int n = A.length;
    int ans[] = new int[n-B+1];
    Deque<Integer> dq = new LinkedList<Integer>();
    int i=0,j=0,l=0;;
    while(j<n){
      while(!dq.isEmpty() && A[j]>dq.getLast()){
        dq.removeLast();
      }
      dq.add(A[j]);
      if(j-i+1<B){
        j++;
      }else if(j-i+1==B){
        ans[l++] = dq.getFirst();
        if(A[i]==dq.getFirst()){
          dq.removeFirst();
        }
        i++;
        j++;
      }
    }
    return ans;
  }

}
