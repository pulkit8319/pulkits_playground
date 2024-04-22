package designPatterns.structural.bridge.withBridge;

public class TestBridge {
	public static void main(String[] args) {
		Color red = new Red();
		Shape redSquare = new Square(red);
		redSquare.applyColor();
		
		Color green = new Green();
		Shape greenCircle = new Circle(green);
		greenCircle.applyColor();
		
		Color blue = new Blue();
		Shape blueCircle = new Circle(blue);
		blueCircle.applyColor();
		
		Shape greenSquare = new Square(green);
		greenSquare.applyColor();
	}
}
