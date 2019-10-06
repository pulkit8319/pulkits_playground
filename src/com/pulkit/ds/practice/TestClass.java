package com.pulkit.ds.practice;

import java.util.HashSet;
import java.util.Set;

public class TestClass {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Pulkit11");
		p1.setTitle("qa");
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("Pulkit");
		p2.setTitle("qa");

		Set<Person> setPerson = new HashSet<>();
		setPerson.add(p1);
		setPerson.add(p2);
		System.out.println(setPerson);
		
		
		  final String s1 = "abc";
		  String s2 = s1 + "def";
		  String s12 = "abcdef";
		  System.out.println(s2);
		  System.out.println(s12 == s2); // true as the s2 create in string pool since final is there
		  String s3 = "abc";
		  String s4 = s3 + "def";
		  System.out.println(s12 == s4);
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
