import java.util.*;

public class MinimumInsertionsToMakeAStringPalindrome{

  public static void main(String[] args){
    String str = "aba";
    System.out.println(findMinInsertions(str));
  }

    private static int findMinInsertions(String S){
      int n = S.length();
      StringBuilder sb = new StringBuilder();
      for(int i=n-1;i>=0;i--){
        sb.append(S.charAt(i));
      }
      String reverse = sb.toString();
      int m = n;
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
          if(S.charAt(i-1)==reverse.charAt(j-1)){
            t[i][j] = 1 + t[i-1][j-1];
          }else{
            t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
          }
        }
      }
      return S.length() - t[n][m];
   }
}
