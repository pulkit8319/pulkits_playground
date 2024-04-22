package designPatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
	
	public Registry() {
		createItems();
	}

	public Item cloneItem(String type) {
		Item item = null;
		try {
			item = (Item) items.get(type).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return item;
	}

	Map<String, Item> items = new HashMap<String, Item>();

	private void createItems() {
		Movie movie = new Movie();
		movie.setTitle("pk");
		movie.setPrice(12.22);
		items.put("movie", movie);

		Book book = new Book();
		book.setTitle("journey");
		book.setPrice(13.44);
		items.put("book", book);
	}
}
