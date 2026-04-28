import java.util.Comparator;

public class AxisComparator implements Comparator<UberDriver> {
    private final int axis; // 0 = x, 1 = y

    public AxisComparator(int axis) {
        this.axis = axis;
    }

    @Override
    public int compare(UberDriver a, UberDriver b) {
        double a1 = (axis == 0) ? a.getX() : a.getY();
        double b1 = (axis == 0) ? b.getX() : b.getY();
        int c = Double.compare(a1,b1);
        if(c != 0) return c;
        // tie breaker if c == 0, then compare y
        double a2 = (axis == 0) ? a.getY() : a.getX();
        double b2 = (axis == 0) ? b.getY() : b.getX();
        return Double.compare(a2,b2);

    }
}
