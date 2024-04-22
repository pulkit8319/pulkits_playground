package designPatterns.structural.bridge.withBridge;

public class Red implements Color {

	@Override
	public void applyColor() {
		System.out.println("Applying red color");
	}

}
