import java.util.*;

public class CoinChangeTopDown{

  public static void main(String[] args){
    int[] coins = {1,2,3};
    int sum = 4;
    int N = 3;
    System.out.println(count(coins, N, sum));
  }

  private static long count(int coins[], int N, int sum){
    long t[][] = new long[N+1][sum+1];
    for(int i=0;i<N+1; i++){
      for(int j=0; j<sum+1;j++){
        if(i==0){
          t[i][j] = 0;
        }
        if(j==0){
          t[i][j] = 1;
        }
      }
    }
    for(int i=1;i<N+1; i++){
      for(int j=1; j<sum+1;j++){
        if(coins[i-1]<=j){
          t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
        }else{
          t[i][j] = t[i-1][j];
        }
      }
    }
    return t[N][sum];
  }

}
