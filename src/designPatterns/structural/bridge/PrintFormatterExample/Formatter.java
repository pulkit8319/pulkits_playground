package designPatterns.structural.bridge.PrintFormatterExample;

import java.util.List;

public interface Formatter {
	
	public String format(String header, List<Detail> details);

}
