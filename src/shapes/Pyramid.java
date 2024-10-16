package shapes;
/**
 * Repersents a Pyramid.
 */

public class Pyramid extends Shape {
	
	private double side;

	/**
	 * Creates a Pyramid with the specified height and side.
	 * @param height the height
	 * @param side the side
	 */
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * Returns the Pyramid's side.
	 * @return the side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * Sets the Pyramid's side.
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

	@Override
	public String toString() {
		return "Pyramid side: " + getSide() + ", volume: " + calcVolume() + ", base area: "
				+ calcBaseArea() + ", height: " + getHeight();
	}
}
