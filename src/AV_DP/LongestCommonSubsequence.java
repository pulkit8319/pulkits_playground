import java.util.*;

public class LongestCommonSubsequence{

  public static void main(String[] args){
    int A = 6, B = 6;
    String str1 = "ABCDGH";
    String str2 = "AEDFHR";
    System.out.println(lcsTopDown(A,B, str1, str2));
  }

  static int lcsRecursive(int x, int y, String s1, String s2)
    {
      if(x==0 || y==0){
        return 0;
      }
      if(s1.charAt(x-1)==s2.charAt(y-1)){
        return 1+lcsRecursive(x-1,y-1,s1,s2);
      }else{
        return Math.max(lcsRecursive(x-1,y,s1,s2),lcsRecursive(x,y-1,s1,s2));
      }
    }

    static int lcsMemoization(int x, int y, String s1, String s2)
      {
        int memo[][] = new int[x+1][y+1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
        return lcsMemoization(x,y,s1,s2,memo);
      }

      static int lcsMemoization(int x, int y, String s1, String s2, int memo[][]){
        if(memo[x][y]!=-1){
          return memo[x][y];
        }
        if(x<=0 || y<=0){
          return 0;
        }
        if(s1.charAt(x-1)==s2.charAt(y-1)){
          memo[x][y] = 1 + lcsMemoization(x-1,y-1,s1,s2,memo);
        }else{
          memo[x][y] = Math.max(lcsMemoization(x,y-1,s1,s2,memo),lcsMemoization(x-1,y,s1,s2,memo));
        }
        return memo[x][y];
      }

      static int lcsTopDown(int x, int y, String s1, String s2){
        int t[][] = new int[x+1][y+1];
        for(int i=0;i<x+1;i++){
          for(int j=0;j<y+1;j++){
            if(i==0 || y==0){
              t[i][j]=0;
            }
          }
        }
        for(int i=1;i<x+1;i++){
          for(int j=1;j<y+1;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
              t[i][j] = 1 + t[i-1][j-1];
            }else{
              t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
          }
        }
        return t[x][y];
      }

}
