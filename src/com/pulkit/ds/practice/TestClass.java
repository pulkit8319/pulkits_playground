package com.pulkit.ds.practice;

interface Interf {
	public int m1(int a, int b);
}

public class TestClass {

	public static void main(String[] args) {
		Runnable r = ()->{
			for(int i=0;i<10;i++) {
			System.out.println("child");
			}
		};
		Thread th = new Thread(r);
		th.start();
		for(int i=0;i<10;i++) {
			System.out.println("main");
		}
	}

}

class Person {
	int id;
	String name;
	String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + id;
		result = 31 * result + name.hashCode();
		result = 31 * result + title.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Person pp = (Person) obj;
		return (pp.id == id && pp.name.equals(name) && pp.title.equals(title));
	}

}
