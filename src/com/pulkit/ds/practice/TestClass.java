package com.pulkit.ds.practice;

import java.util.List;
import java.util.Scanner;


public class TestClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int num = s.nextInt();                 // Reading input from STDIN
        String[] arr = new String[num];
        for(int i=0;i<num;i++){
        	arr[i] = s.next();
        }
        for(int i=0;i<arr.length;i++){
        	if(arr[i].contains("https://")){
        	Website web = new Website(arr[i]);
        	}
        }
       List<String> str = Website.getMostVisitedPages();
        int size = str.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
        	System.out.println(str.get(i));
        }
	}
	
}


