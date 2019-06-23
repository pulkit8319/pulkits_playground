package designPatterns.structural.Composite;

public class Waitress {

	private MenuComponent menu;
	
	public Waitress(MenuComponent menu) {
		this.menu = menu;
	}
	
	public void print() {
		menu.print();
	}
}
