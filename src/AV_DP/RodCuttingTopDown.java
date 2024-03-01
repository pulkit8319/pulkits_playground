import java.util.*;

public class RodCuttingTopDown{

  public static void main(String[] args){
    int  N = 8;
    int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
    System.out.println(cutRodSimilarTo01Knapsack(price,N));
  }

  private static int cutRod(int price[], int n) {
    int rodLength = n;
    int t[][] = new int[n+1][rodLength+1];
    for(int i=0;i<n+1;i++){
      for(int j=0;j<rodLength+1;j++){
        if(i==0 || j==0){
          t[i][j] = 0;
        }
      }
    }
    for(int i=1;i<n+1;i++){
      for(int j=1;j<rodLength+1;j++){
        if(i<=j){
          t[i][j] = Math.max(price[i-1] + t[i][j - i], t[i-1][j]);
        }else{
          t[i][j] = t[i-1][j];
        }
      }
    }
    return t[n][rodLength];
  }

  private static int cutRodSimilarTo01Knapsack(int price[], int n) {
    int[] length = new int[n];
    for(int i=0;i<n;i++){
      length[i] = i+1;
    }
    int rodLength = n;
    int t[][] = new int[n+1][rodLength+1];
    for(int i=0;i<n+1;i++){
      for(int j=0;j<rodLength+1;j++){
        if(i==0 || j==0){
          t[i][j] = 0;
        }
      }
    }
    for(int i=1;i<n+1;i++){
      for(int j=1;j<rodLength+1;j++){
        if(length[i-1]<=j){
          t[i][j] = Math.max(price[i-1] + t[i][j - length[i-1]], t[i-1][j]);
        }else{
          t[i][j] = t[i-1][j];
        }
      }
    }
    return t[n][rodLength];
  }

}
