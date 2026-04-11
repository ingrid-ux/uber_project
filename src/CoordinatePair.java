import java.lang.Math;
public abstract class CoordinatePair {
	
	private double x = -1;
	private double y = -1;
	
	/**
	 * 
	 * @param x x coordinate of the uber driver
	 * @param y y coordinate of the uber driver
	 */
	public CoordinatePair(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	/**
	 * Static method attached to the CoordinatePair class that returns the distance between 2 instances
	 * of child classes of CoordinatePair
	 * @param a CoordinatePair 1
	 * @param b CoordinatePair 2
	 * @return The distance between the two uber drivers as a double
	 */
	public static double dist(CoordinatePair a, CoordinatePair b) {
		return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
	}
	
}
