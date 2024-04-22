import java.util.*;

public class CoinChangeRecursive{

  public static void main(String[] args){
    int[] coins = {1,2,3};
    int sum = 4;
    int N = 3;
    System.out.println(count(coins, N, sum));
  }

  private static long count(int coins[], int N, int sum) {
    if(sum==0){
      return 1;
    }
    if(N==0){
      return 0;
    }
    if(coins[N-1]<=sum){
      return count(coins, N, sum - coins[N-1]) + count(coins, N-1, sum);
    }else{
      return count(coins, N-1, sum);
    }
}
}
