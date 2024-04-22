import java.util.*;

public class SubsequencePatternMatching{

  public static void main(String[] args){
    String str1 = "abc";
    String str2 = "ahbgdc";
    System.out.println(isSubSequence(str1,str2));
  }

  private static boolean isSubSequence(String s, String t){
      int n = s.length();
      int m = t.length();
      int td[][] = new int[n+1][m+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
          if(i==0 || j==0){
            td[i][j] = 0;
          }
        }
      }
      for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
          if(s.charAt(i-1)==t.charAt(j-1)){
            td[i][j] = 1+td[i-1][j-1];
          }else{
            td[i][j] = Math.max(td[i-1][j],td[i][j-1]);
          }
        }
      }
      return s.length()==td[n][m];
    }

}
