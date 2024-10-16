package shapes;
/**
 * Represents a PentagonalPrism.
 */

public class PentagonalPrism extends Prism
{

	/**
	 * Creates a PentagonalPrism with specified height and side.
	 * @param height the height
	 * @param side the side
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (5 * getSide() * getSide() * Math.tan(54)) / 4;
	}
	
	@Override
	public String toString() {
		return "PentagonalPrism base area: " + calcBaseArea() + ", side: " + getSide() + ", volume: "
				+ calcVolume() + ", height: " + getHeight();
	}	
}
