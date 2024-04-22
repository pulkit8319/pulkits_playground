import java.util.*;

public class MinimumDeletionToMakeAPalindrome{

  public static void main(String[] args){
    String str = "aba";
    System.out.println(minDeletions(str,str.length()));
  }

  private static int minDeletions(String str, int n)
    {
      StringBuilder sb = new StringBuilder();
      for(int i=n-1;i>=0;i--){
        sb.append(str.charAt(i));
      }
      String reverse = sb.toString();
      int t[][] = new int[n+1][n+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<n+1;j++){
          if(i==0 || j==0){
            t[i][j] = 0;
          }
        }
      }
      for(int i=1;i<n+1;i++){
        for(int j=1;j<n+1;j++){
          if(str.charAt(i-1)==reverse.charAt(j-1)){
            t[i][j] = 1+ t[i-1][j-1];
          }else{
            t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
          }
        }
      }
      return n - t[n][n];
    }

}
