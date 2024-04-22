package designPatterns.creational.factorymethod.website;

import java.util.ArrayList;

public class BlogWebsite extends Website {

	@Override
	public void createPages() {
		pages = new ArrayList<>();
		pages.add(new BlogPage());
		pages.add(new ContactPage());
		pages.add(new AboutPage());
	}

}
