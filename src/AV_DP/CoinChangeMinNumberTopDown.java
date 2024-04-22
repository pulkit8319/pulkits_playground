import java.util.*;

public class CoinChangeMinNumberTopDown{

  public static void main(String[] args){
    int[] coins = {25};
    int V = 30;
    int M = 1;
    System.out.println(minCoins(coins, M, V));
  }

  private static int minCoins(int coins[], int M, int V)
	{
    int t[][] = new int[M+1][V+1];
    for(int i=0; i<M+1; i++){
      for (int j=0;j<V+1;j++){
        if(j==0){
          t[i][j] = 0;
        }
        if(i==0){
          t[i][j] = Integer.MAX_VALUE-1;
        }
        if(i==1 && j>0){
          if(j%coins[i-1]==0){
            t[i][j] = j/coins[i-1];
          }else{
            t[i][j] = Integer.MAX_VALUE-1;
          }
        }
      }
    }
    for(int i=2; i<M+1; i++){
      for (int j=1;j<V+1;j++){
        if(coins[i-1]<=j){
          t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]);
        }else{
          t[i][j] = t[i-1][j];
        }
      }
    }
    return t[M][V]==Integer.MAX_VALUE-1?-1:t[M][V];
	}

}
