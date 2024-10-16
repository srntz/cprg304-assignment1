package shapes;
/**
 * Represents a OctagonalPrism.
 */

public class OctagonalPrism extends Prism
{

	/**
	 * Creates a OctagonalPrism with specified height and side.
	 * @param height the height
	 * @param side the side
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * getSide() * getSide();
	}
	
	@Override
	public String toString() {
		return "OctagonalPrism base area: " + calcBaseArea() + ", side: " + getSide() + ", volume: "
				+ calcVolume() + ", height: " + getHeight();
	}	
}
