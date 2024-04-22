import java.util.*;

public class CoinChangeMinNumberRecursion{

  public static void main(String[] args){
    int[] coins = {25, 10, 5};
    int V = 30;
    int M = 3;
    System.out.println(minCoinsAdityaVerma(coins, M, V));
  }

  private static int minCoins(int coins[], int M, int V)
	{
    int count  = 0;
    return minCoins(coins, M,V,count);
	}

  private static int minCoins(int coins[], int M, int V, int count)
	{
    if(V==0){
      return count;
    }
    if(M==0){
      return -1;
    }
    if(coins[M-1]<=V){
      int take = minCoins(coins, M, V-coins[M-1], count+1);
      int notTake = minCoins(coins, M-1, V, count);
      if(take==-1){
        return notTake;
      }else if(notTake==-1){
          return take;
      }else{
          return Math.min(take,notTake);
      }
    }else{
      return minCoins(coins, M-1, V, count);
    }
	}

  private static int minCoinsAdityaVerma(int coins[], int M, int V)
	{
    if(V==0){
      return 0;
    }
    if(M==0){
      return Integer.MAX_VALUE-1;
    }
    if(coins[M-1]<=V){
      return Math.min(minCoinsAdityaVerma(coins, M,V-coins[M-1]) + 1,minCoinsAdityaVerma(coins, M-1, V) );
    }else{
      return minCoinsAdityaVerma(coins, M-1, V);
    }

	}



}
