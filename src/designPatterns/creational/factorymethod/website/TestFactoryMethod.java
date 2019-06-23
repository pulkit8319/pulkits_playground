package designPatterns.creational.factorymethod.website;

public class TestFactoryMethod {
	public static void main(String[] args) {
	ShoppingWebsite shopSite = (ShoppingWebsite) WebSiteFactory.getWesite(WebSiteEnum.SHOP);
	shopSite.createPages();
	System.out.println(shopSite.pages);
	
	BlogWebsite blogSite = (BlogWebsite) WebSiteFactory.getWesite(WebSiteEnum.BLOG);
	blogSite.createPages();
	System.out.println(blogSite.pages);
	}
}
