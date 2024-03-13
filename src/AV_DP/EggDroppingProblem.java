import java.util.*;

public class EggDroppingProblem{

  public static void main(String[] args){
    int N = 2;
    int K = 10;
    System.out.println(eggDropMemoization(N,K));
  }

  static int eggDropRecursive(int n, int k)
	{
    if(k==0 || k==1 || n==1){
      return k;
    }
    int min = Integer.MAX_VALUE;
    for(int f=1;f<=k;f++){
      int temp = 1 + Math.max(eggDropRecursive(n-1,f-1),eggDropRecursive(n,k-f));
      min = Math.min(min,temp);
    }
    return min;
	}

  static int eggDropMemoization(int n, int k)
	{
    int memo[][] = new int[n+1][k+1];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
    return eggDropMemoizationOptimized(n,k,memo);
	}

  static int eggDropMemoization(int n, int k, int memo[][]){
   if(k==0 || k==1 || n==1){
     return k;
   }
   if(memo[n][k]!=-1){
     return memo[n][k];
   }
   int min = Integer.MAX_VALUE;
   for(int f = 1; f<=k;f++){
     int temp = 1 + Math.max(eggDropMemoization(n-1,f-1,memo),eggDropMemoization(n,k-f,memo));
     min = Math.min(temp,min);
   }
   memo[n][k] = min;
   return min;
 }

  static int eggDropMemoizationOptimized(int n, int k, int memo[][]){
    if(k==0 || k==1 || n==1){
      return k;
    }
    if(memo[n][k]!=-1){
      return memo[n][k];
    }
    int min = Integer.MAX_VALUE;
    for(int f = 1; f<=k;f++){
      int eggBreak = 0;
      if(memo[n-1][f-1]!=-1){
          eggBreak  = memo[n-1][f-1];
      }else{
        eggBreak = eggDropMemoizationOptimized(n-1,f-1,memo);
        memo[n-1][f-1] = eggBreak;
      }
      int eggNotBreak = 0;
      if(memo[n][k-f]!=-1){
        eggNotBreak  = memo[n][k-f];
      }else{
        eggNotBreak = eggDropMemoizationOptimized(n,k-f,memo);
        memo[n][k-f] = eggNotBreak;
      }
      int temp = 1 + Math.max(eggBreak,eggNotBreak);
      min = Math.min(temp,min);
    }
    memo[n][k] = min;
    return min;
  }

}
