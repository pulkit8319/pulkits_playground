import java.util.*;

public class KnapsackRecursiveMemoization{

  private static int[][] t = new int[102][102];

  public static void main(String[] args){
    int N = 3;
    int W = 4;
    int values[] = {1,2,3};
    int weight[] = {4,5,1};
    Arrays.stream(t).forEach(a -> Arrays.fill(a,-1));
    int maxValue = knapSack(W,weight,values,N);
    System.out.println(maxValue);
  }

  private static int knapSack(int W, int wt[], int val[], int n)
    {
      if(n==0 || W==0){
        return 0;
      }
      if(t[n][W]!=-1){
        return t[n][W];
      }
      if(wt[n-1]<=W){
        t[n][W] = Math.max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1),knapSack(W,wt,val,n-1));
        return t[n][W];
      }else{
        t[n][W] = knapSack(W,wt,val,n-1);
        return t[n][W];
      }
    }
}
