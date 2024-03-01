import java.util.*;

public class KnapsackRecursiveMemoization{

  public static void main(String[] args){
    int N = 3;
    int W = 4;
    int values[] = {1,2,3};
    int weight[] = {4,5,1};
    int maxValue = knapSack(W,weight,values,N);
    System.out.println(maxValue);
  }

  private static int knapSack(int W, int wt[], int val[], int n)
    {
      int[][] memo = new int[1001][1001];
      Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
      return knapSack(W,wt,val,n, memo);
    }

    private static int knapSack(int W, int wt[], int val[], int n, int memo[][]){
      if(n==0 || W==0){
        return 0;
      }
      if(memo[n][W]!=-1){
        return memo[n][W];
      }
      if(wt[n-1]<=W){
        memo[n][W] = Math.max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1, memo),knapSack(W,wt,val,n-1, memo));
        return memo[n][W];
      }else{
        memo[n][W] = knapSack(W,wt,val,n-1, memo);
        return memo[n][W];
      }
    }
}
