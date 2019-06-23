package designPatterns.structural.Composite;

public class TestComposite {

	public static void main(String[] args) {
		MenuComponent menu = new Menu("Main Menu", "Main menu");
		
		MenuComponent starterMenu = new  Menu("Starter", "has all starters");
		MenuComponent mainCourseMenu = new Menu("Main Course", "has all amin course");
		MenuComponent dessertMenu = new Menu("Desserts", "Has All desserts");
		
		menu.add(starterMenu);
		menu.add(mainCourseMenu);
		menu.add(dessertMenu);
		
		MenuComponent paneerTikka = new  MenuItem("Paneer Tikka", "Paneer Tikka spicy", 60.00);
		MenuComponent haraBharaKabab = new  MenuItem("hara bhara kebab", "Hara bhara kebab", 90.00);
		MenuComponent chickenTikka = new  MenuItem("chicken tikka", "chicken tikka spicy", 120.00);
		starterMenu.add(paneerTikka);
		starterMenu.add(haraBharaKabab);
		starterMenu.add(chickenTikka);
		
		MenuComponent tandooriRoti = new  MenuItem("Tandoori roti", "Tandoori roti", 12.00);
		MenuComponent mixVeg = new  MenuItem("mix veg", "mix veg", 30.00);
		MenuComponent paneerSabji = new  MenuItem("paneer sabji", "paneer sabji", 67.00);
		mainCourseMenu.add(tandooriRoti);
		mainCourseMenu.add(mixVeg);
		mainCourseMenu.add(paneerSabji);
		
		MenuComponent vanillaIceCream = new  MenuItem("Vanilla ice cream", "vanilla ice cream", 20.00);
		MenuComponent gulabJamun = new  MenuItem("gulab jamun", "gulab jamun", 10.00);
		dessertMenu.add(vanillaIceCream);
		dessertMenu.add(gulabJamun);
		
		Waitress waitress = new Waitress(menu);
		waitress.print();
	}
}

