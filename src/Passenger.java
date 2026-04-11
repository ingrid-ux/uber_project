
public class Passenger extends CoordinatePair {
	
	UberDriver closestUberDriver = null;
	
	public Passenger(double x, double y) {
		super(x, y); //Assigns the x and y values inherited from CoordinatePair
	}
	
	public void setClosestUberDriver(UberDriver u) {
		closestUberDriver = u;
	}
	
	public UberDriver getClosestUberDriver() {
		return closestUberDriver;
	}
	
}
