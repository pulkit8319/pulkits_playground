package com.pulkit.ds.practice.leetCode.Array;

//You are given an array of strings words and a string chars.
//A string is good if it can be formed by characters from chars (each character can only be used once).
//Return the sum of lengths of all good strings in words.
public class FindWordsThatCanbeFormedByCharacters {

	public static void main(String[] args) {
		String words[] = {"cat","bt","hat","tree"};
		int num = countCharacters(words, "atach");
		System.out.println(num);
	}

	private static int countCharacters(String[] words, String chars) {
		int ch[] = new int[26];
		for (int i = 0; i < chars.length(); i++) {
			ch[chars.charAt(i)-97]++;
		}
		int count= 0;
		for(String word:words){
			boolean b = true;
			int ch1[] = ch.clone();
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i)-97;
				ch1[index]--;
				if(ch1[index]<0){
					b = false;
					break;
				}
			}
			if(b){
				count+=word.length();
			}
		}
		return count;
	}

	
}
