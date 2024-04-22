import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxAreaRectangleInBinaryMatrix{

  public static void main(String[] args){
    char[][] matrix = {{'1'}};
    System.out.println(maximalRectangle(matrix));
  }

  private static int maximalRectangle(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] arr = new int[n][m];
    for(int i=0;i<matrix[0].length;i++){
      arr[0][i] = Character.getNumericValue(matrix[0][i]);
    }
    for(int i=1;i<n;i++){
      for(int j=0;j<m;j++){
        int num = Character.getNumericValue(matrix[i][j]);
        if(num!=0){
          arr[i][j] = (arr[i-1][j]+num);
        }
      }
    }
    int maxArea = -1;
    for(int i=0;i<matrix.length;i++){
      int area = maxAreaHistogram(arr[i]);
      maxArea = Math.max(area,maxArea);
    }
    return maxArea;
  }

  private static int maxAreaHistogram(int[] hist){
    int n = hist.length;
    Stack<Integer> stk = new Stack<>();
    int[] nextSmallerOnLeftIndex = new int[n];
    int[] nextSmallerOnRightIndex = new int[n];
    //find nextSmallerOnLeftIndex
    for(int i=0;i<n;i++){
      while(!stk.isEmpty() && hist[stk.peek()]>=hist[i]){
        stk.pop();
      }
      nextSmallerOnLeftIndex[i] = stk.isEmpty()?-1:stk.peek();
      stk.push(i);
    }
    stk.clear();
    //find nextSmallerOnRightIndex
    for(int i=n-1;i>=0;i--){
      while(!stk.isEmpty() && hist[stk.peek()]>=hist[i]){
        stk.pop();
      }
      nextSmallerOnRightIndex[i] = stk.isEmpty()? n :stk.peek();
      stk.push(i);
    }
    int maxArea = -1;
    for(int i=0;i<n;i++){
      int area = (nextSmallerOnRightIndex[i]-nextSmallerOnLeftIndex[i]-1)*hist[i];
      maxArea = Math.max(area,maxArea);
    }
    return maxArea;
  }

}
