import java.util.*;
import java.lang.*;
import java.io.*;

public class KClosestPointsToOrigin{

  public static void main(String[] args){
    int arr[][] = {{3,3},{5,-1},{-2,4}};
    int k = 2;
    int ans[][] = kClosest(arr,k);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i][0]+"   "+ans[i][1]);
    }
  }

  private static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
      @Override
      public int compare(Pair a, Pair b){
        return Double.compare(b.dist, a.dist);
      }
    });
    for(int i=0;i<points.length;i++){
      int point[] = points[i];
      double dist = Math.sqrt(Math.pow(point[0],2)+Math.pow(point[1],2));
      pq.add(new Pair(dist,point));
      if(pq.size()>k){
        pq.poll();
      }
    }
    int ans[][] = new int[k][2];
    while(!pq.isEmpty()){
      int[] p = pq.poll().point;
      ans[k-1][0] = p[0];
      ans[k-1][1] = p[1];
      k--;
    }
    return ans;
  }
}

class Pair{
  double dist;
  int[] point;
  public Pair(double dist, int[] point){
    this.dist = dist;
    this.point = point;
  }
}
