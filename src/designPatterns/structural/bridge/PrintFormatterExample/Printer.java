package designPatterns.structural.bridge.PrintFormatterExample;

import java.util.List;

public abstract class Printer {
	
	public String print(Formatter printFormatter) {
		return printFormatter.format(getHeader(), getDetails());
	}
	
	public abstract String getHeader();
	public abstract List<Detail> getDetails();
	
}
