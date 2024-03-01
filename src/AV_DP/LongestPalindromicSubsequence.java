import java.util.*;

public class LongestPalindromicSubsequence{

  public static void main(String[] args){
    String str = "abcd";
    System.out.println(longestPalinSubseq(str));
  }

  private static int longestPalinSubseq(String S)
   {
     StringBuilder sb = new StringBuilder();
     for(int i=S.length()-1;i>=0;i--){
       sb.append(S.charAt(i));
     }
     String reverseOfS = sb.toString();
     int n = S.length();
     int m = reverseOfS.length();
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
         if(S.charAt(i-1)==reverseOfS.charAt(j-1)){
           t[i][j] = 1 + t[i-1][j-1];
         }else{
           t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
         }
       }
     }
     return t[n][m];
   }



}
