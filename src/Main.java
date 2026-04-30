import java.util.ArrayList;

public class Main {

    public static UberDriver nearestBaseline(ArrayList<UberDriver> drivers, Passenger p) {
        UberDriver best = drivers.get(0);
        double bestD2 = CoordinatePair.dist2(best, p);

        for (int i = 1; i < drivers.size(); i++) {
            UberDriver d = drivers.get(i);
            double d2 = CoordinatePair.dist2(d, p);
            if (d2 < bestD2) {
                bestD2 = d2;
                best = d;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        
        // create uber drivers
        ArrayList<UberDriver> drivers = new ArrayList<>();
        drivers.add(new UberDriver(1, 2));
        drivers.add(new UberDriver(5, 5));
        drivers.add(new UberDriver(-2, 3));
        
        // create passengers
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(2, 3));
        passengers.add(new Passenger(6, 4));
        passengers.add(new Passenger(0, 0));
        
        // for each passenger, find the closest driver
        for (Passenger p : passengers) {
            UberDriver closest = null;
            double minDistance = Double.MAX_VALUE;
            
            for (UberDriver d : drivers) {
                double distance = CoordinatePair.dist(p, d);
                
                if (distance < minDistance) {
                    minDistance = distance;
                    closest = d;
                }
            }
            
            //closest driver to passenger
            p.setClosestUberDriver(closest);
        }
        
        //print
        for (Passenger p : passengers) {
            UberDriver d = p.getClosestUberDriver();
            
            if (d != null) {
                System.out.println("Passenger at (" + p.getX() + ", " + p.getY() + 
                                   ") Closest Driver at (" + d.getX() + ", " + d.getY() + ")");
            } else {
                System.out.println("Passenger at (" + p.getX() + ", " + p.getY() + 
                                   ") No driver nearby available");
            }
        }

        KDTree tree = new KDTree(drivers);

        for (Passenger p : passengers) {
            UberDriver b = nearestBaseline(drivers, p);
            UberDriver k = tree.findNearest(p);

            System.out.printf("Passenger at (%f, %f) | Closest Driver (%f, %f), kd-tree (%f, %f)%n",
                    p.getX(), p.getY(),
                    b.getX(), b.getY(),
                    k.getX(), k.getY());
        }




    }
}