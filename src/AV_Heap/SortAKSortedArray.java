import java.util.*;
import java.lang.*;
import java.io.*;

public class SortAKSortedArray{

  public static void main(String[] args){
    int arr[] = {6,5,3,2,8,10,9};
    int n = 7;
    int k = 3;
    System.out.println(nearlySorted(arr,n,k));
  }

  private static ArrayList <Integer> nearlySorted(int arr[], int num, int k)
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for(int i=0;i<num;i++){
      pq.add(arr[i]);
      if(pq.size()>k){
        list.add(pq.poll());
      }
    }
    while(!pq.isEmpty()){
      list.add(pq.poll());
    }
    return list;
  }

}
