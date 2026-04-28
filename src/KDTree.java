
import java.util.ArrayList;
import java.util.List;

public class KDTree {

    private static class Node{
        UberDriver point;
        Node left, right; // left & right child
        int axis; // 0 : x split // 1: y split

        public Node(UberDriver p, int axis){
            this.point = p;
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

    public UberDriver nearest(Passenger q) {
        Best best = new Best(root.point, CoordinatePair.dist2(root.point, q));
        search(root, q, best);
        return best.point;
    }

    private static class Best {
        UberDriver point;
        double d2;
        Best(UberDriver point, double d2) { this.point = point; this.d2 = d2; }
    }

    private void search(Node node, Passenger q, Best best) {

    }
}

