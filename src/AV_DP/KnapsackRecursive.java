public class KnapsackRecursive{

  public static void main(String[] args){
    int N = 3;
    int W = 4;
    int values[] = {1,2,3};
    int weight[] = {4,5,1};
    int maxValue = knapSack(W,weight,values,N);
    System.out.println(maxValue);
  }

  private static int knapSack(int W, int wt[], int val[], int N)
    {
      if(N==0 || W==0){
        return 0;
      }
      if(wt[N-1]<=W){
        return Math.max(val[N-1] + knapSack(W - wt[N-1], wt, val, N-1), knapSack(W,wt,val,N-1));
      }else{
        return knapSack(W, wt, val, N-1);
      }
    }
}
