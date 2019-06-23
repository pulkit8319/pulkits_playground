package designPatterns.creational.factorymethod.website;

public class WebSiteFactory {
	
	public static Website getWesite(WebSiteEnum site) {
		switch (site) {
		case BLOG:
			return new BlogWebsite();
		case SHOP:
			return new ShoppingWebsite();
		default:
			return null;
		}
	}

}
