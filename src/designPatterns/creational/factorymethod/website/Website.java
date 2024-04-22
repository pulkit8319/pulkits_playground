package designPatterns.creational.factorymethod.website;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

	List<Page> pages = new ArrayList<Page>();
	
	public Website() {
		createPages();
	}
	
	public abstract void createPages();
	
}
