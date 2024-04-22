import java.util.*;
import java.lang.*;
import java.io.*;

//Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
//If there is no possible substring then print -1.
public class LongestKUniqueCharactersString{

  public static void main(String[] args){
    String s = "aaaa";
    int k = 2;
    System.out.println(longestkSubstr(s,k));
  }

  private static int longestkSubstr(String s, int k) {
    Map<Character,Integer> map = new HashMap<>();
    int i=0,j=0,n = s.length();
    int ans = -1;
    while(j<n){
      char ch  = s.charAt(j);
      map.put(ch,map.getOrDefault(ch,0)+1);
      if(map.size()==k){
        ans = Math.max(ans,j-i+1);
      }else if(map.size()>k){
        while(map.size()>k){
          char chi = s.charAt(i);
          if(map.containsKey(chi)){
            int freq = map.get(chi);
            freq--;
            if(freq==0){
              map.remove(chi);
            }else{
              map.put(chi,freq);
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
