import java.util.*;
import java.lang.*;
import java.io.*;

public class CountOccurenceOfAnagrams{

  public static void main(String[] args){
    String txt = "aabaabaa";
    String pat = "aaba";
    System.out.println(search(pat,txt));
  }

  private static int search(String pat, String txt) {
    int count = 0;
    int countMap = 0;
    Map<Character,Integer> map = new HashMap<Character,Integer>();
    for(int i=0;i<pat.length();i++){
      char ch = pat.charAt(i);
      if(map.containsKey(ch)){
        map.put(ch,map.get(ch)+1);
      }else{
        map.put(ch,1);
        countMap++;
      }
    }
    int i=0,j=0,n = txt.length(),k = pat.length();
    while(j<n){
      char chj = txt.charAt(j);
      if(map.containsKey(chj)){
        int freq = map.get(chj);
        freq--;
        if(freq==0){
          countMap--;
        }
        map.put(chj,freq);
      }
      if(j-i+1<k){
        j++;
      }else if(j-i+1==k){
        if(countMap==0){
          count++;
        }
        char chi = txt.charAt(i);
        if(map.containsKey(chi)){
        int f =  map.get(chi);
        f++;
        if(f==1){
          countMap++;
        }
        map.put(chi,f);
        }
        i++;
        j++;
      }
    }
    return count;
  }

}
