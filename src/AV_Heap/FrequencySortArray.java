import java.util.*;
import java.lang.*;
import java.io.*;

public class FrequencySortArray{

  public static void main(String[] args){
    int arr[] = {1,1,2,2,2,3,4};
    int ans[] = frequencySort(arr);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]);
    }
  }

  private static int[] frequencySort(int[] nums) {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i=0;i<nums.length;i++){
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
      @Override
      public int compare(Pair a, Pair b){
        if(a.freq!=b.freq){
          return Integer.compare(a.freq,b.freq);
        }else{
          return Integer.compare(b.num,a.num);
        }
      }
    });
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
      pq.add(new Pair(entry.getValue(),entry.getKey()));
    }
    int n = nums.length;
    int ans[]  = new int[n];
    int i = 0;
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      int freq = p.freq;
      while(freq>0){
        ans[i++] = p.num;
        freq--;
      }
    }
    return ans;
  }
}

class Pair{
  int freq;
  int num;
  public Pair(int freq,int num){
    this.freq = freq;
    this.num = num;
  }
}
