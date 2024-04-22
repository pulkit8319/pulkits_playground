import java.util.*;

public class PalindromePartitioning{

  public static void main(String[] args){
    String str = "aaabba";
    System.out.println(palindromicPartitionMemoization(str));
  }

  private static int palindromicPartitionRecursive(String str)
    {
      int i=0,j = str.length()-1;
      return palindromicPartitionRecursive(str,i,j);
    }

    private static int palindromicPartitionRecursive(String str, int i, int j)
      {
        if(i>=j){
          return 0;
        }
        if(isPalindrome(str,i,j)){
          return 0;
        }
        int minPartitions = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
          int partitions = 1 + palindromicPartitionRecursive(str,i,k) + palindromicPartitionRecursive(str,k+1,j);
          minPartitions = Math.min(minPartitions, partitions);
        }
        return minPartitions;
      }

      private static boolean isPalindrome(String str, int i, int j){
        while(i<=j){
          if(str.charAt(i)!=str.charAt(j)){
            return false;
          }
          i++;
          j--;
        }
        return true;
      }

      private static int palindromicPartitionMemoization(String str)
        {
          int i=0,j=str.length()-1;
          int memo[][] = new int[j+1][j+1];
          Boolean pmemo[][] = new Boolean[j+1][j+1];
          Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
          return palindromicPartitionMemoization(str,i,j,memo,pmemo);
        }

        private static int palindromicPartitionMemoization(String str, int i, int j,int memo[][], Boolean pmemo[][])
          {
            if(memo[i][j]!=-1){
              return memo[i][j];
            }
            if(i>=j){
              return 0;
            }
            if(pmemo[i][j]!=null && pmemo[i][j]){
              return 0;
            }
            pmemo[i][j] = isPalindrome(str,i,j);
            if(pmemo[i][j]){
              return 0;
            }
            int minValue = Integer.MAX_VALUE;
            for(int k = i;k<j;k++){
              int left = 0;
              if(memo[i][k]!=-1){
                left = memo[i][k];
              }else{
                left = palindromicPartitionMemoization(str,i,k,memo,pmemo);
              }
              int right = 0;
              if(memo[k+1][j]!=-1){
                right = memo[k+1][j];
              }else{
                right = palindromicPartitionMemoization(str,k+1,j,memo,pmemo);
              }
              int partitions = 1 + left + right;
              minValue = Math.min(minValue, partitions);
            }
            return memo[i][j] = minValue;
          }
}
