import java.util.*;

public class KnapsackTopDown{

  public static void main(String[] args){
    int N = 3;
    int W = 4;
    int values[] = {1,2,3};
    int weight[] = {4,5,1};
    int maxValue = knapSack(W,weight,values,N);
    System.out.println(maxValue);
  }

  private static int knapSack(int W, int wt[], int val[], int n)
    {
      int[][] t = new int[n+1][W+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<W+1;j++){
          if(i==0 || j==0){
            t[i][j]=0;
          }
        }
      }
      for(int k=1;k<n+1;k++){
        for(int l=1;l<W+1;l++){
          if(wt[k-1]<=l){
            t[k][l] = Math.max(val[k-1]+ t[k-1][l-wt[k-1]],t[k-1][l]);
          }else{
            t[k][l] = t[k-1][l];
          }
        }
    }
    return t[n][W];
  }
}
