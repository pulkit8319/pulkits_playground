package designPatterns.structural.bridge.PrintFormatterExample;

import java.util.List;

public class PrintFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		details.forEach(detail ->{
			sb.append(detail.getLabel()+":"+detail.getValue());
		});
		return sb.toString();
	}
}
