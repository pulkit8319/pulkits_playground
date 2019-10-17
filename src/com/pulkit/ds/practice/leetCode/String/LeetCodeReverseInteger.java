package com.pulkit.ds.practice.leetCode.String;

//Given a 32-bit signed integer, reverse digits of an integer.
public class LeetCodeReverseInteger {

	public static void main(String[] args) {
		int x = 120;
		int y = reverseInteger1(x);
		System.out.println(y);
	}

	//bekarSolution
	private static int reverseInteger(int x) {
		int y = 0;
		try {
			boolean isNegative = false;
			if(x<0) {
				isNegative = true;
			}
			char[] ch = String.valueOf(x).toCharArray();
			int l = 0;
			int r = ch.length-1;
			while(l<r) {
				char temp = ch[l];
				ch[l] = ch[r];
				ch[r] = temp;
				l++;
				r--;
			}
			String s = new String();
			for (int i = 0; i < ch.length; i++) {
				if(ch[i]=='-')
					continue;
				s+=ch[i];
			}
			y = Integer.parseInt(s);
			if(isNegative)
				y = -y;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return y;
	}
	
	//good solution
	private static int reverseInteger1(int x) {
		boolean isNegative = false;
		if(x<0) {
			isNegative = true;
			x = -x;
		}
		long rev = 0l;
		while(x>0) {
			int rem = x%10;
			x/=10;
			rev = rev*10+rem;
		}
		if(rev>Integer.MAX_VALUE)
			return 0;
		if(isNegative)
			return -(int)rev;
		return (int)rev;
	}

}
