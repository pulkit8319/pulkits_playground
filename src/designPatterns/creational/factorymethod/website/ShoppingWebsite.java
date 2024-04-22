package designPatterns.creational.factorymethod.website;

import java.util.ArrayList;

public class ShoppingWebsite extends Website {

	@Override
	public void createPages() {
		pages = new ArrayList<>();
		pages.add(new CartPage());
		pages.add(new ContactPage());
		pages.add(new AboutPage());
	}

}
