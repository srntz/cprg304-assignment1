package shapes;
/**
 * Repersents a Cylinder.
 */

public class Cylinder extends Shape {
	
	private double radius;

	/**
	 * Creates a Cylinder with the specified height and radius.
	 * @param height the height
	 * @param radius the radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	/**
	 * Returns the Cylinder's radius.
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the Cylinder's radius.
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Cylinder radius: " + getRadius() + ", volume: " + calcVolume() + ", base area: "
				+ calcBaseArea() + ", height: " + getHeight();
	}
}
