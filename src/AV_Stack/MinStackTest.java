import java.util.*;
import java.lang.*;
import java.io.*;

public class MinStackTest{

  public static void main(String[] args){
    Stack<Integer> stk = new Stack<>();
    MinStackOptimized minStack = new MinStackOptimized();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}

//using O(1) space
class MinStackOptimized{
  int minEle;
      Stack<Integer> s;

      // Constructor
      MinStackOptimized()
  	{
      s = new Stack<>();
      minEle = -1;
  	}

      /*returns min element from stack*/
      int getMin()
      {
        return minEle;
      }

      /*returns poped element from stack*/
      int pop()
      {
        if(s.isEmpty()){
          return -1;
        }
        int num = s.pop();
        if(num<minEle){
         int temp = minEle;
          minEle = 2*minEle-num;
          num = temp;
        }
        return num;
      }

      /*push element x into the stack*/
      void push(int x)
      {
        if(s.isEmpty()){
          s.push(x);
          minEle = x;
        }else if(x<minEle){
          s.push(2*x-minEle);
          minEle = x;
        }else{
          s.push(x);
        }
      }
}

//using O(n) space way 2
class MinStackWay2{
  Stack<Pair> stk;
  public MinStackWay2() {
    stk = new Stack<>();
    }

    public void push(int val) {
      if(stk.isEmpty()){
        stk.push(new Pair(val,val));
      }else{
        stk.push(new Pair(val,Math.min(val,stk.peek().min)));
      }
    }


    public void pop() {
        stk.pop();
    }

    public int top() {
      return stk.peek().num;
    }

    public int getMin() {
      return stk.peek().min;
    }
}

class Pair{
  int num;
  int min;
  public Pair(int num, int min){
    this.num = num;
    this.min = min;
  }
}

// Using O(n) space
class MinStack{

  Stack<Integer> min = new Stack<>();

  public void push(int a,Stack<Integer> s)
	{  if(min.isEmpty()){
        min.push(a);
      }else{
        min.push(Math.min(a,min.peek()));
      }
      s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
          if(min.isEmpty()){
            return -1;
          }else{
            min.pop();
            return s.pop();
          }
	       }
	public int min(Stack<Integer> s)
        {
           if(!min.isEmpty()){
             return min.peek();
           }else{
             return -1;
           }
	       }
	public boolean isFull(Stack<Integer>s, int n)
        {
           return s.size()==n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           return s.isEmpty();
      	}
}
