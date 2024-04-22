import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxAreaHistogram{

  public static void main(String[] args){
    int arr[] = {16,2,5,4,5,1,6};
    System.out.println(largestRectangleArea(arr));
  }

    private static int largestRectangleArea(int[] heights) {
      int n = heights.length;
      int nextSmallerOnRightIndex[] = new int[n];
      int nextSmallerOnLeftIndex[] = new int[n];
      //Next smaller on right
      Stack<Integer> stk = new Stack<>();
      for(int i = n-1;i>=0;i--){
        while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
          stk.pop();
        }
        nextSmallerOnRightIndex[i] = stk.isEmpty()? n : stk.peek();
        stk.push(i);
      }
      //next smaller on left
      stk.clear();
      for(int i=0;i<n;i++){
        while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
          stk.pop();
        }
        nextSmallerOnLeftIndex[i] = stk.isEmpty()? -1 : stk.peek();
        stk.push(i);
      }
      int maxArea = -1;
      for(int i=0;i<n;i++){
        int area = (nextSmallerOnRightIndex[i]-nextSmallerOnLeftIndex[i]-1)*heights[i];
        maxArea = Math.max(area,maxArea);
      }
      return maxArea;
    }

}
