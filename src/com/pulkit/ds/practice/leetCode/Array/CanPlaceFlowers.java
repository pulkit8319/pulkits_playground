package com.pulkit.ds.practice.leetCode.Array;

//Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
public class CanPlaceFlowers {

	public static void main(String[] args) {
		int flowerbed[] = {0};
		boolean b = canPlaceFlowers(flowerbed, 1);
		System.out.print(b);
	}

	private static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int l = flowerbed.length;
		if(l==1 && flowerbed[0]==0 && n==1){
			return true;
		}
		if (n == 0) {
			return true;
		}
		for (int i = 0; i < l; i++) {
			while (i < l && flowerbed[i] == 1) {
				i += 2;
			}
			if (i == 0 && flowerbed[i + 1] == 0) {
				flowerbed[i++] = 1;
				n--;
			} else if (i < l - 1 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
				flowerbed[i++] = 1;
				n--;
			} else if (i == l - 1 && flowerbed[i - 1] == 0) {
				flowerbed[i++] = 1;
				n--;
			}
			if (n == 0) {
				return true;
			}
		}
		return false;
	}

}
