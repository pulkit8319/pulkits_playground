import java.util.*;

public class PrintLongestCommonSubsequence{

  public static void main(String[] args){
    int A = 6, B = 6;
    String str1 = "ABCDGH";
    String str2 = "AEDFHR";
    findLCSTopDownImproved(A,B, str1, str2);
  }

    public static String findLCSRecursive(int n, int m, String s1, String s2){
       if(n==0 || m==0){
         return "";
       }
       if(s1.charAt(n-1)==s2.charAt(m-1)){
         return findLCSRecursive(n-1,m-1,s1,s2) + s1.charAt(n-1);
       }else{
         String str1 = findLCSRecursive(n-1,m,s1,s2);
         String str2 = findLCSRecursive(n,m-1,s1,s2);
         if(str1.length()>str2.length()){
           return str1;
         }else{
           return str2;
         }
       }
    }

    public static String findLCSMemoization(int n, int m, String s1, String s2){
      String memo[][] = new String[n+1][m+1];
      return findLCSMemoization(n,m,s1,s2,memo);
    }

    public static String findLCSMemoization(int n, int m, String s1, String s2,String memo[][]){
      if(memo[n][m]!=null){
        return memo[n][m];
      }
       if(n==0 || m==0){
         return "";
       }
       if(s1.charAt(n-1)==s2.charAt(m-1)){
         memo[n][m] =  findLCSRecursive(n-1,m-1,s1,s2) + s1.charAt(n-1);
       }else{
         String str1 = findLCSRecursive(n-1,m,s1,s2);
         String str2 = findLCSRecursive(n,m-1,s1,s2);
         if(str1.length()>str2.length()){
           memo[n][m] = str1;
         }else{
           memo[n][m] = str2;
         }
       }
       return memo[n][m];
    }

    public static String findLCSTopDown(int n, int m, String s1, String s2){
      String t[][] = new String[n+1][m+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
          if(i==0 || j==0){
            t[i][j] = "";
          }
        }
      }
      for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
          if(s1.charAt(i-1)==s2.charAt(j-1)){
            t[i][j] = t[i-1][j-1]+s1.charAt(i-1);
          }else{
            if(t[i-1][j]!=null && t[i][j-1]!=null && t[i-1][j].length()>t[i][j-1].length()){
              t[i][j] = t[i-1][j];
            }else{
              t[i][j] = t[i][j-1];
            }
          }
        }
      }
      return t[n][m];
    }

    public static void findLCSTopDownImproved(int n, int m, String s1, String s2){
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
          if(s1.charAt(i-1)==s2.charAt(j-1)){
            t[i][j] = 1+t[i-1][j-1];
          }else{
            t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
          }
        }
      }
      int i = n;
      int j = m;
      int index = 0;
      char[] lcs = new char[t[n][m]];
      while(i>0 && j>0){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          lcs[index++] = s1.charAt(i-1);
          i--;
          j--;
        }else if(t[i-1][j]>t[i][j-1]){
          i--;
        }else{
          j--;
        }
      }
      for(int k=lcs.length-1;k>=0;k--){
        System.out.println(lcs[k]);
      }
    }

}
