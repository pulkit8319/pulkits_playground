package com.pulkit.ds.practice;

@FunctionalInterface
public interface FuncInterface {
	
	abstract void m3();
	
	int i=12;
	
	static void m1(){
		System.out.println(i);
	}
	
	default void m2(){
		System.out.println(i);
	}

}
