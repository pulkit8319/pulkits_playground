package designPatterns.structural.Decorator;

public class TestDecorator {
	
	public static void main(String[] args) {
		
		Sandwich sandwich  = new MeatDecorator(new DressingDecorator(new SimpleSandwich()));
		System.out.println(sandwich.make());
	}

}
