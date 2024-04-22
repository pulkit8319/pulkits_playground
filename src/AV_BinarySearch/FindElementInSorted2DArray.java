import java.util.*;
import java.lang.*;
import java.io.*;

public class FindElementInSorted2DArray{

  public static void main(String[] args){
    int matrix[][] = {{ 3, 30, 38},
                      {33, 43, 60},
                      {35, 51, 69}};
    int n = 3, m = 3, x = 36;
    System.out.println(search(matrix,n,m,x));
  }

  static boolean search(int matrix[][], int n, int m, int x)
  {
    int i = 0,j=m-1;
    while(i<n && j>=0){
      if(matrix[i][j]==x){
        return true;
      }else if(matrix[i][j]<x){
        i++;
      }else{
        j--;
      }
    }
    return false;
	}

}
