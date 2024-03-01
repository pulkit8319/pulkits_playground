import java.util.*;

public class LongestCommonString{

  static Integer maxCount = Integer.MIN_VALUE;

  public static void main(String[] args){
    int n = 2, m = 2;
    String S1 = "AB";
    String S2 = "BC";
    System.out.println(longestCommonSubstrTopDown(S1,S2,n,m));
  }

  private static int longestCommonSubstrRecursive(String S1, String S2, int n, int m){
      int count = 0;
      longestCommonSubstrRecursive(S1,S2,n,m,count);
      return maxCount;
    }

      private static int longestCommonSubstrRecursive(String S1, String S2, int n, int m, int count){
        if(n==0 || m==0){
          return 0;
        }
        if(S1.charAt(n-1)==S2.charAt(m-1)){
          return longestCommonSubstrRecursive(S1,S2,n-1,m-1,count+1);
        }else{
          maxCount = Math.max(count,maxCount);
          return Math.max(longestCommonSubstrRecursive(S1,S2,n-1,m,0),longestCommonSubstrRecursive(S1,S2,n,m-1,0));
        }
      }

      private static int longestCommonSubstrMemoization(String S1, String S2, int n, int m){
          int memo[][] = new int[n+1][m+1];
          Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
          longestCommonSubstrMemoization(S1,S2,n,m,memo);
          return maxCount;
        }

        private static int longestCommonSubstrMemoization(String S1, String S2, int n, int m, int memo[][]){
          if(memo[n][m]!=-1){
            return memo[n][m];
          }
          if(n==0 || m==0){
            return 0;
          }
          if(S1.charAt(n-1)==S2.charAt(m-1)){
            memo[n][m] = 1 + longestCommonSubstrMemoization(S1,S2,n-1,m-1,memo);
            maxCount = Math.max(memo[n][m],maxCount);
            return memo[n][m];
          }else{
            memo[n][m] = 0;
          }
          longestCommonSubstrMemoization(S1,S2,n-1,m,memo);
          longestCommonSubstrMemoization(S1,S2,n,m-1,memo);
          return memo[n][m];
        }

        private static int longestCommonSubstrTopDown(String S1, String S2, int n, int m){
          int max = 0;
          int t[][] = new int[n+1][m+1];
          for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
              if(i==0 || j==0){
                t[i][j] = 0;
              }
            }
          }
          for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
              if(S1.charAt(i-1)==S2.charAt(j-1)){
                t[i][j] = 1 + t[i-1][j-1];
                max = Math.max(max,t[i][j]);
              }else{
                t[i][j] = 0;
              }
            }
          }
          return max;
        }

}
