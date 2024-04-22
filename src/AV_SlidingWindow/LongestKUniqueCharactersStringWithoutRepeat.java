import java.util.*;
import java.lang.*;
import java.io.*;

//Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
//If there is no possible substring then print -1.
public class LongestKUniqueCharactersStringWithoutRepeat{

  public static void main(String[] args){
    String s = "pwwkew";
    System.out.println(lengthOfLongestSubstring(s));
  }

  private static int lengthOfLongestSubstring(String s) {
    int ans = 0;
    int i=0,j=0,n=s.length();
    Map<Character,Integer> map = new HashMap<Character,Integer>();
    while(j<n){
      char chj = s.charAt(j);
      map.put(chj,map.getOrDefault(chj,0)+1);
      if(map.size()==j-i+1){
        ans = Math.max(ans,map.size());
        j++;
      }else if(map.size()<j-i+1){
        while(map.size()<j-i+1){
          char chi = s.charAt(i);
          int freq = map.get(chi);
          freq--;
          if(freq==0){
            map.remove(chi);
          }else{
            map.put(chi,freq);
          }
          i++;
        }
        j++;
      }
    }
    return ans;
  }

}
