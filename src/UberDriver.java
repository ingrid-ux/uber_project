import java.lang.Math;
import java.util.ArrayList;
public class UberDriver extends CoordinatePair {
	
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	
	public UberDriver(double x, double y) {
		super(x, y); //Assigns the x and y values inherited from CoordinatePair
	}
	
	/**
	 * Appends a passenger to the end of the passengerList
	 * @param p passenger to be appended
	 */
	public void addPassenger(Passenger p) {
		passengerList.add(p);
	}
	
	/**
	 * Inserts a passenger at a specific index of the passengerList
	 * @param p passenger to be inserted
	 * @param i index to insert at
	 */
	public void insertPassenger(Passenger p, int i) {
		passengerList.add(i, p);
	}
	
	/**
	 * Returns the passenger at index i of the passengerList
	 * @param i index of the passenger
	 * @return Passenger object at index i
	 */
	public Passenger getPassenger(int i) {
		return passengerList.get(i);
	}
	
	/**
	 * Removes a passenger object from index i of the passengerList
	 * @param i index of the object to be removed
	 */
	public void removePassenger(int i) {
		passengerList.remove(i);
	}
	
	/**
	 * Static method attached to the UberDriver class that returns the distance between 2 UberDriver objects
	 * using their coordinates. Specifically UberDriver objects
	 * @param a UberDriver 1
	 * @param b UberDriver 2
	 * @return The distance between the two uber drivers as a double
	 */
	public static double dist(UberDriver a, UberDriver b) {
		return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
	}
	
}
