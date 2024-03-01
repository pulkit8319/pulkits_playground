import java.util.*;

public class MatrixChainMultiplication{

  public static void main(String[] args){
    int arr[] = {10, 30, 5, 60};
    int N = 4;
    System.out.println(matrixMultiplicationRecursive(N,arr));
  }

  private static int matrixMultiplicationRecursive(int N, int arr[])
  {
    int i = 1,j = N-1;
    return matrixMultiplicationRecursive(arr,i,j);
  }

  private static int matrixMultiplicationRecursive(int arr[],int i,int j)
  {
    if(i>=j){
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for(int k = i;k<=j-1;k++){
      int temp = matrixMultiplicationRecursive(arr,i,k) + matrixMultiplicationRecursive(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
      min = Math.min(min,temp);
    }
    return min;
  }

  private static int matrixMultiplicationMemoization(int N, int arr[])
  {
    int memo[][] = new int[N][N];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a,Integer.MAX_VALUE));
    return matrixMultiplicationMemoization(arr,1,N-1,memo);
  }

  private static int matrixMultiplicationMemoization(int arr[], int i, int j, int memo[][])
  {
    if(memo[i][j]!=Integer.MAX_VALUE){
      return memo[i][j];
    }
    if(i>=j){
      return 0;
    }
    for(int k = i;k<=j-1;k++){
      int temp = matrixMultiplicationMemoization(arr,i,k,memo) + matrixMultiplicationMemoization(arr,k+1,j,memo) + arr[i-1]*arr[k]*arr[j];
      memo[i][j] = Math.min(memo[i][j],temp);
    }
    return memo[i][j];
  }

}
