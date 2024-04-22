package designPatterns.creational.prototype;

public class TestPrototype {

	public static void main(String[] args) {
		Registry reg = new Registry();
		Movie m1 = (Movie)reg.cloneItem("movie");
		m1.setDuration("2 hrs");
		System.out.println(m1.getTitle()+" "+m1.getPrice()+" "+m1.getDuration());
		
		Book book = (Book) reg.cloneItem("book");
		book.setPages("230");
		System.out.println(book.getTitle()+" "+book.getPrice()+" "+book.getPages());
		
	}
}
