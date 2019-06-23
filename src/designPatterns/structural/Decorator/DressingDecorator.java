package designPatterns.structural.Decorator;

public class DressingDecorator extends SimpleSandwich{

	Sandwich customSandWich;
	
	public DressingDecorator(Sandwich customSandWich) {
		this.customSandWich = customSandWich;
	}
	
	@Override
	public String make() {
		return customSandWich.make() + addDressing();
	}

	private String addDressing() {
		return "Mustard ";
	}
	
}
