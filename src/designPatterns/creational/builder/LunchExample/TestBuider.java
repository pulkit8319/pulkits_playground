package designPatterns.creational.builder.LunchExample;

public class TestBuider {

	public static void main(String[] args) {
		LunchOrder.LunchBuilder lunchBuilder = new LunchOrder.LunchBuilder();
		//LunchOrder.LunchBuilder lunchBuilder = new LunchBuilder();
		//lunchBuilder.chapati("chapati").condiments("condi").veggie("paneer").salad("salad");
		//lunchBuilder.condiments("condi").veggie("paneer").salad("salad");
		lunchBuilder.condiments("condi").salad("salad");
		LunchOrder lunchOrder = lunchBuilder.build();
		System.out.println(lunchOrder.getChapati());
		System.out.println(lunchOrder.getVeggie());
		System.out.println(lunchOrder.getCondiments());
		System.out.println(lunchOrder.getSalad());
	}
}
