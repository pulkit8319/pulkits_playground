package designPatterns.structural.Composite;

public class MenuItem extends MenuComponent {

	private String name;
	private String description;
	private double price;

	public MenuItem(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescriprion() {
		return this.description;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item Name: " + name).append("\n");
		sb.append("Item Desc: " + description).append("\n");
		sb.append("Item price: " + price).append("\n");
		System.out.println(sb.toString());
	}

}
