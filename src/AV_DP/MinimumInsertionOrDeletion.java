import java.util.*;

public class MinimumInsertionOrDeletion{

//https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
  public static void main(String[] args){
    String str1 = "geeksforgeeks";
    String str2 = "geeks";
    System.out.println(minOperations(str1,str2));
  }

  private static int minOperations(String str1, String str2)
  	{
      int n = str1.length();
      int m = str2.length();
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
          if(str1.charAt(i-1)==str2.charAt(j-1)){
            t[i][j] = 1+ t[i-1][j-1];
          }else{
            t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
          }
        }
      }
      return n + m - 2*t[n][m];
  	}

}
