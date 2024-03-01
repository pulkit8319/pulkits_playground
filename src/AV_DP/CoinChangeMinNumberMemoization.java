import java.util.*;

public class CoinChangeMinNumberMemoization{

  public static void main(String[] args){
    int[] coins = {25};
    int V = 30;
    int M = 1;
    System.out.println(minCoinsAdityaVerma(coins, M, V));
  }

  private static int minCoins(int coins[], int M, int V)
	{
    int count  = 0;
    int memo[][] = new int[M+1][V+1];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
    return minCoins(coins, M,V,count, memo);
	}

  private static int minCoins(int coins[], int M, int V, int count, int memo[][])
	{
    if(memo[M][V]!=-1){
      return memo[M][V];
    }
    if(V==0){
      return count;
    }
    if(M==0){
      return -1;
    }
    if(coins[M-1]<=V){
      int take = minCoins(coins, M, V-coins[M-1], count+1, memo);
      int notTake = minCoins(coins, M-1, V, count, memo);
      if(take==-1){
        memo[M][V] =  notTake;
      }else if(notTake==-1){
          memo[M][V] =  take;
      }else{
          memo[M][V] =  Math.min(take,notTake);
      }
    }else{
      memo[M][V] =  minCoins(coins, M-1, V, count, memo);
    }
    return memo[M][V];
	}

  private static int minCoinsAdityaVerma(int coins[], int M, int V)
	{
      int memo[][] = new int[M+1][V+1];
      Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
      return minCoinsAdityaVerma(coins, M, V, memo);
    }

  private static int minCoinsAdityaVerma(int coins[], int M, int V, int memo[][])
	{
    if(memo[M][V]!=-1){
      return memo[M][V];
    }
    if(V==0){
      return 0;
    }
    if(M==0){
      return Integer.MAX_VALUE-1;
    }
    if(coins[M-1]<=V){
      memo[M][V] =  Math.min(minCoinsAdityaVerma(coins, M,V-coins[M-1], memo) + 1,minCoinsAdityaVerma(coins, M-1, V, memo) );
    }else{
      memo[M][V] =  minCoinsAdityaVerma(coins, M-1, V, memo);
    }
    return memo[M][V];
  }


}
