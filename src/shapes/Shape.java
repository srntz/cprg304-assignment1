package shapes;
/**
 * Represents a Shape object
 */

public abstract class Shape implements Comparable<Shape> {
	
	private double height;	
	   
	/**
	 * Creates a Shape with the specified height.
	 * @param height the height
	 */
	public Shape(double height) {
		super();
		this.height = height;
	}
	
	/**
	 * Returns the Shape's height.
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the Shape's height.
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public int compareTo(Shape other) {
		if(this.height > other.height) return 1;
		if(this.height < other.height) return -1;
		return 0;
	}

	/**
	 * Returns the calculated base are of the Shape
	 */
	public abstract double calcVolume();
	
	/**
	 * Returns the calculated volume of the Shape.	
	 * @return volume
	 */
	public abstract double calcBaseArea();

	@Override
	public String toString() {
		return "Height: " + getHeight() + ", base area: " + calcVolume() + ", volume: "
				+ calcBaseArea();
	}
}
