package designPatterns.structural.Decorator;

public class MeatDecorator extends SimpleSandwich{
	
	Sandwich customSandwich;
	
	public MeatDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}
	
	@Override
	public String make() {
		return customSandwich.make() + addMeat();
	}

	private String addMeat() {
		return "Meat ";
	}

}
