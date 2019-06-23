package designPatterns.structural.Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent{

	private String name;
	private String description;
	private List<MenuComponent> menuComponents = new ArrayList<>();
	
	public Menu(String name,String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	
	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item Name: " + name).append("\n");
		sb.append("Item Desc: " + description).append("\n");
		System.out.println(sb.toString());
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while(iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent)iterator.next();
			menuComponent.print();
		}
	}
	
}
