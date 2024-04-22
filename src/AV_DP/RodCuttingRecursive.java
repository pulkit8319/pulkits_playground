import java.util.*;

public class RodCuttingRecursive{

  public static void main(String[] args){
    int  N = 8;
    int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
    System.out.println(cutRod(price,N));
  }

  private static int cutRod(int price[], int n) {
      return cutRod(price, n, n);
  }

  private static int cutRod(int price[], int n, int rodLength) {
      if(rodLength==0){
        return 0;
      }
      if(n==0){
        return 0;
      }
      if(n<=rodLength){
        return Math.max(price[n-1] + cutRod(price,n,rodLength - n), cutRod(price, n-1,rodLength));
      }else{
        return cutRod(price, n-1,rodLength);
      }
  }
}
