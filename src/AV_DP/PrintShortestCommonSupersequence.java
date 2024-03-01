import java.util.*;

public class PrintShortestCommonSupersequence{

  public static void main(String[] args){
    String str1 = "agg";
    String str2 = "gxt";
    System.out.println(shortestCommonSupersequenceTopDown(str1,str2));
  }

  private static String shortestCommonSupersequenceRecursive(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    return shortestCommonSupersequenceRecursive(str1,str2,n,m,"");
   }

   private static String shortestCommonSupersequenceRecursive(String str1, String str2,int n, int m,String result) {
     if(n==0){
       return str2.substring(0,m)+result;
     }
     if(m==0){
       return str1.substring(0,n)+result;
     }
     if(str1.charAt(n-1)==str2.charAt(m-1)){
       return shortestCommonSupersequenceRecursive(str1,str2,n-1,m-1,str1.charAt(n-1)+result);
     }else{
       String s1 = shortestCommonSupersequenceRecursive(str1,str2,n-1,m,str1.charAt(n-1)+result);
       String s2 = shortestCommonSupersequenceRecursive(str1,str2,n,m-1,str2.charAt(m-1)+result);
       if(s1.length()<s2.length()){
         return s1;
       }else{
         return s2;
       }
     }
    }

    private static String shortestCommonSupersequenceMemoization(String str1, String str2) {
      int n = str1.length();
      int m = str2.length();
      String memo[][] = new String[n+1][m+1];
      return shortestCommonSupersequenceMemoization(str1,str2,n,m,"",memo);
     }

     private static String shortestCommonSupersequenceMemoization(String str1, String str2,int n, int m,String result,String memo[][]) {
       if(memo[n][m]!=null){
         return memo[n][m];
       }
       if(n==0){
         return str2.substring(0,m)+result;
       }
       if(m==0){
         return str1.substring(0,n)+result;
       }
       if(str1.charAt(n-1)==str2.charAt(m-1)){
         memo[n][m] =  shortestCommonSupersequenceMemoization(str1,str2,n-1,m-1,str1.charAt(n-1)+result,memo);
         return memo[n][m];
       }else{
         String s1 = shortestCommonSupersequenceMemoization(str1,str2,n-1,m,str1.charAt(n-1)+result,memo);
         String s2 = shortestCommonSupersequenceMemoization(str1,str2,n,m-1,str2.charAt(m-1)+result,memo);
         if(s1.length()<s2.length()){
           memo[n][m] =  s1;
         }else{
           memo[n][m] =  s2;
         }
         return memo[n][m];
       }
      }

      private static String shortestCommonSupersequenceTopDown(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int t[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
          for(int j=0;j<m+1;j++){
            if(i==0){
              t[i][j] = 0;
            }
            if(j==0){
              t[i][j] = 0;
            }
          }
        }
        for(int i=1;i<n+1;i++){
          for(int j=1;j<m+1;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
              t[i][j] = 1 + t[i-1][j-1];
            }else{
              t[i][j] =  Math.max(t[i-1][j],t[i][j-1]);
            }
          }
        }
        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
          if(str1.charAt(i-1)==str2.charAt(j-1)){
            sb.append(str1.charAt(i-1));
            i--;
            j--;
          }else if(t[i-1][j]>t[i][j-1]){
              sb.append(str1.charAt(i-1));
              i--;
            }else{
              sb.append(str2.charAt(j-1));
              j--;
            }
          }
          while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
          }
          while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
          }
        return sb.reverse().toString();
       }

}
