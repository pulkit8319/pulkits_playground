package designPatterns.structural.Composite;

public abstract class MenuComponent {

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public String getDescriprion() {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void print() {
		throw new UnsupportedOperationException();
	}

}
