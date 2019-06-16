package strutural.bridge.withBridge;

public class Square extends Shape{
	
	public Square(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		color.applyColor();
	}

}
