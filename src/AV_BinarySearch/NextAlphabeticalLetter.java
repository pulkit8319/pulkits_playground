import java.util.*;
import java.lang.*;
import java.io.*;

public class NextAlphabeticalLetter{

  public static void main(String[] args){
    char[] letters = {'c','f','j'};
    System.out.println(nextGreatestLetter(letters,'d'));
  }

    public static char nextGreatestLetter(char[] letters, char target) {
      char ans = letters[0];
      int start = 0;
      int end = letters.length-1;
      while(start<=end){
        int mid = start+(end-start)/2;
        if(letters[mid]>target){
          ans = letters[mid];
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return ans;
    }
}
