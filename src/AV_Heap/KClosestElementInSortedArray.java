import java.util.*;
import java.lang.*;
import java.io.*;

public class KClosestElementInSortedArray{

  public static void main(String[] args){
    int arr[] =  {12, 16, 22, 30, 35, 39, 42,
         45, 48, 50, 53, 55, 56};
    int n = 13;
    int k = 4;
    int x = 35;
    int ans[] = printKClosest(arr,n,k,x);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]);
    }
  }

  private static int[] printKClosest(int[] arr, int n, int k, int x) {
    Comparator<Pair> com = new Comparator<Pair>() {
      @Override
      public int compare(Pair a, Pair b){
        if(a.diff==b.diff){
          return a.num>b.num?1:-1;
        }else{
          return a.diff<b.diff?1:-1;
        }
      }
    };
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(com);
    for(int i=0;i<n;i++){
      if(x!=arr[i]){
        pq.add(new Pair(Math.abs(x-arr[i]),arr[i]));
        if(pq.size()>k){
          pq.poll();
        }
      }
    }
    int ans[] = new int[k];
    while(!pq.isEmpty()){
      ans[k-1] = pq.poll().num;
      k--;
    }
    return ans;
  }

}

class Pair{
  int diff;
  int num;

  public Pair(int diff,int num){
    this.diff = diff;
    this.num = num;
  }
}
