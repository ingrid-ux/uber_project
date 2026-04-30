
import java.util.ArrayList;
import java.util.List;

public class KDTree {

    private static class Node{
        UberDriver driver;
        Node left, right; // left & right child
        int axis; // 0 : x split // 1: y split

        public Node(UberDriver p, int axis){
            this.driver = p;
            this.axis = axis;
        }
    }

    private final Node root;

    public KDTree(List<UberDriver> drivers){
        // initializing root
        ArrayList<UberDriver> copy = new ArrayList<>(drivers);
        this.root = build(copy,0);
    }

    private Node build(ArrayList<UberDriver> pts, int depth){
        if(pts.isEmpty()) return null;

        int axis = depth % 2;

        pts.sort(new AxisComparator(axis));
        int mid = pts.size() / 2;
        UberDriver median = pts.get(mid);
        Node node = new Node(median, axis);
        node.left = build(new ArrayList<>(pts.subList(0, mid)), depth + 1);
        node.right = build(new ArrayList<>(pts.subList(mid + 1, pts.size())), depth + 1);

        return node;
    }

    public UberDriver findNearest(Passenger p) {
        return search(root, p, root.driver);
    }

    private static class Best {
        UberDriver point;
        double d2;
        Best(UberDriver point, double d2) { this.point = point; this.d2 = d2; }
    }

    private UberDriver search(Node node, Passenger p, UberDriver best) {
        if (node == null) return best;

        if (CoordinatePair.dist2(node.driver,p) < CoordinatePair.dist2(best,p)){
            best = node.driver;
        }

        double diff = (node.axis == 0) ? (p.getX() - node.driver.getX()) : (p.getY() - node.driver.getY());

        Node near = (diff < 0) ? node.left : node.right;
        Node far = (diff < 0) ? node.right : node.left;

        best = search(near,p,best);

        if(Math.pow(diff,2) < CoordinatePair.dist2(best,p)){
            best = search(far,p,best);
        }
        return best;

    }
}

