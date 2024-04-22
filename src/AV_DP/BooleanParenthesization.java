import java.util.*;
import java.lang.*;
import java.io.*;

public class BooleanParenthesization{

//DP
  public static void main(String[] args){
    String s = "T|T&F^T";
    int n = 7;
    System.out.println(countWays(n,s));
  }

  private static int countWays(int n, String s){
      int i=0,j=n-1;
      Map<String,Integer> map = new HashMap<>();
      return countWays(s,i,j,true,map);
    }

    private static int countWays(String s, int i, int j, boolean isTrue,Map<String,Integer> map){
        if(i>j){
          return 0;
        }
        if(i==j){
          if(isTrue){
            if(s.charAt(i)=='T'){
              return 1;
            }else{
              return 0;
            }
          }else{
              if(s.charAt(i)=='F'){
                return 1;
              }else{
                return 0;
              }
          }
        }
        String key = String.valueOf(i)+String.valueOf(j)+String.valueOf(isTrue);
        if(map.containsKey(key)){
          return map.get(key);
        }
        int count = 0;
        for(int k=i+1;k<j;k=k+2){
          int countLeftTrue = countWays(s,i,k-1,true,map);
          int countRightTrue = countWays(s,k+1,j,true,map);
          int countLeftFalse = countWays(s,i,k-1,false,map);
          int countRightFalse = countWays(s,k+1,j,false,map);
          count+= noOfWays(s.charAt(k),countLeftTrue,countRightTrue,countLeftFalse,countRightFalse,isTrue);
        }
        map.put(key,count);
        return count;
      }

      private static int noOfWays(char ch, int countLeftTrue,int countRightTrue,int countLeftFalse,int countRightFalse,boolean isTrue){
        if(ch=='|'){
          if(isTrue)
          return countLeftTrue*countRightFalse + countLeftFalse*countRightTrue + countLeftTrue*countRightTrue;
          else
          return countLeftFalse*countRightFalse;
        }else if(ch=='^'){
          if(isTrue)
          return countLeftTrue*countRightFalse + countLeftFalse*countRightTrue;
          else
          return countLeftTrue*countRightTrue + countLeftFalse*countRightFalse;
        }else{
          if(isTrue)
          return countLeftTrue*countRightTrue;
          else
          return countLeftFalse*countRightFalse + countLeftFalse*countRightTrue + countRightFalse*countLeftTrue;
        }
      }



}
