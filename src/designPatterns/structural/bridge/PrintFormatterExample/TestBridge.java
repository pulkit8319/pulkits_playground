package designPatterns.structural.bridge.PrintFormatterExample;

public class TestBridge {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setGenre("Action");
		movie.setTitle("Mozambi");
		movie.setRuntime("2:30");
		movie.setYear("2014");
		
		Formatter printFormatter = new PrintFormatter();
		Printer moviePrinter = new MoviePrinter(movie);
		String str = moviePrinter.print(printFormatter);
		System.out.println(str);
		
		Formatter htmlFormatter = new HtmlFormatter();
		String htmlString = moviePrinter.print(htmlFormatter);
		System.out.println(htmlString);
	}

}
