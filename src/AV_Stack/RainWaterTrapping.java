import java.util.*;
import java.lang.*;
import java.io.*;

public class RainWaterTrapping{

  public static void main(String[] args){
    int height[] = {4,2,0,3,2,5};
    System.out.println(trap(height));
  }

  private static int trap(int[] height) {
    int n = height.length;
    int[] maxOnleft = new int[n];
    int[] maxOnRight = new int[n];
    // find maxOnleft
    maxOnleft[0] = height[0];
    for(int i=1;i<n;i++){
      maxOnleft[i] = Math.max(maxOnleft[i-1],height[i]);
    }
    // find maxOnRight
    maxOnRight[n-1] = height[n-1];
    for(int i=n-2;i>=0;i--){
      maxOnRight[i] = Math.max(maxOnRight[i+1],height[i]);
    }
    //Find watre trapping for individual building
    int waterTrapped = 0;
    for(int i=0;i<n;i++){
      waterTrapped+=(Math.min(maxOnleft[i],maxOnRight[i])-height[i]);
    }
    return waterTrapped;
  }
}
