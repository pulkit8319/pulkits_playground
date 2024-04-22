import java.util.*;

public class CoinChangeMemoization{

  public static void main(String[] args){
    int[] coins = {1,2,3};
    int sum = 4;
    int N = 3;
    System.out.println(count(coins, N, sum));
  }

  private static long count(int coins[], int N, int sum){
    int memo[][] = new int[N+1][sum+1];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
    return count(coins, N, sum, memo);
  }

  private static long count(int coins[], int N, int sum, int memo[][]) {
    if(memo[N][sum]!=-1){
      return memo[N][sum];
    }
    if(sum==0){
      return 1;
    }
    if(N==0){
      return 0;
    }
    if(coins[N-1]<=sum){
      return count(coins, N, sum - coins[N-1], memo) + count(coins, N-1, sum, memo);
    }else{
      return count(coins, N-1, sum, memo);
    }
}
}
