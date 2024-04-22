import java.util.*;
import java.lang.*;
import java.io.*;

public class PickFruitsIntoBasket{

  public static void main(String[] args){
    int[] fruits = {0};
    System.out.println(totalFruit(fruits));
  }

  private static int totalFruit(int[] fruits) {
    int i=0,j=0,n=fruits.length,k=2;
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    int ans = 0,countMap=0;
    while(j<n){
      int fruitsJ = fruits[j];
      if(map.containsKey(fruitsJ)){
        map.put(fruitsJ,map.get(fruitsJ)+1);
      }else{
        map.put(fruitsJ,1);
      }
      countMap++;
      if(map.size()<=k){
        ans = Math.max(ans,countMap);
      }else if(map.size()>k){
        while(map.size()>k){
          int fruitsI = fruits[i];
          if(map.containsKey(fruitsI)){
            int freq = map.get(fruitsI);
            freq--;
            countMap--;
            if(freq==0){
              map.remove(fruitsI);
            }else{
              map.put(fruitsI,freq);
            }
          }
          i++;
        }
      }
      j++;
    }
    return ans;
  }

}
