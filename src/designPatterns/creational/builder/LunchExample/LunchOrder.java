package designPatterns.creational.builder.LunchExample;

public class LunchOrder {
	
	public static class LunchBuilder{
		
		private String chapati;
		private String veggie;
		private String salad;
		private String condiments;
		
		public LunchBuilder() {
		}
		
		public LunchOrder build() {
			return new LunchOrder(this);
		}
		
		public LunchBuilder chapati(String chapati) {
			this.chapati = chapati;
			return this;
		}
		public LunchBuilder veggie(String veggie) {
			this.veggie = veggie;
			return this;
		}
		public LunchBuilder salad(String salad) {
			this.salad = salad;
			return this;
		}
		public LunchBuilder condiments(String condiments) {
			this.condiments = condiments;
			return this;
		}
		
	}
	
	private String chapati;
	private String veggie;
	private String salad;
	private String condiments;
	
	public LunchOrder(LunchBuilder lunchBuilder) {
		this.chapati = lunchBuilder.chapati;
		this.veggie = lunchBuilder.veggie;
		this.salad = lunchBuilder.salad;
		this.condiments = lunchBuilder.condiments;
	}
	
	public String getChapati() {
		return chapati;
	}
	
	public String getCondiments() {
		return condiments;
	}
	
	public String getSalad() {
		return salad;
	}
	
	public String getVeggie() {
		return veggie;
	}

}
