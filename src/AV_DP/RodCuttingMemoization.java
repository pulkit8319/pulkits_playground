import java.util.*;

public class RodCuttingMemoization{

  public static void main(String[] args){
    int  N = 8;
    int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
    System.out.println(cutRod(price,N));
  }

  private static int cutRod(int price[], int n) {
      int memo[][] = new int[n+1][n+1];
      Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
      return cutRod(price, n, n, memo);
  }

  private static int cutRod(int price[], int n, int rodLength, int memo[][]) {
      if(memo[n][rodLength]!=-1){
        return memo[n][rodLength];
      }
      if(rodLength==0){
        return 0;
      }
      if(n==0){
        return 0;
      }
      if(n<=rodLength){
        memo[n][rodLength] = Math.max(price[n-1] + cutRod(price,n,rodLength - n, memo), cutRod(price, n-1,rodLength, memo));
      }else{
        memo[n][rodLength] = cutRod(price, n-1,rodLength, memo);
      }
      return memo[n][rodLength];
  }
}
