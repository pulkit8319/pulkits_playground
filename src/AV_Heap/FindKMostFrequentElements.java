import java.util.*;
import java.lang.*;
import java.io.*;

public class FindKMostFrequentElements{

  public static void main(String[] args){
    int arr[] =  {2, 2, 8};
    int k = 2;
    int ans[] = topK(arr,k);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]);
    }
  }

  private static int[] topK(int[] nums, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
      @Override
      public int compare(Pair a, Pair b){
        return Integer.compare(a.freq,b.freq);
    }
    });
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i=0;i<nums.length;i++){
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }
    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
      pq.add(new Pair(entry.getValue(),entry.getKey()));
      if(pq.size()>k){
        pq.poll();
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
  int freq;
  int num;
  public Pair(int freq, int num){
    this.freq = freq;
    this.num = num;
  }
}
