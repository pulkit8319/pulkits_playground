import java.util.*;

public class ShortestCommonSupersequence{

  public static void main(String[] args){
    int A = 4, B = 4;
    String str1 = "abcd";
    String str2 = "xycd";
    System.out.println(shortestCommonSupersequence(str1,str2, A, B));
  }

  public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        return m + n - lcs(X,Y,m,n);
    }

    public static int lcs(String X,String Y,int m,int n){
          int t[][] = new int[m+1][n+1];
          for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
              if(i==0 || j==0){
                t[i][j] = 0;
              }
            }
          }
          for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
              if(X.charAt(i-1)==Y.charAt(j-1)){
                t[i][j] = 1+t[i-1][j-1];
              }else{
                t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
              }
            }
          }
          return t[m][n];
        }

}
