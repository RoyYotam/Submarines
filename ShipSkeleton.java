
public class ShipSkeleton {
    private Point start;
    private int length;
    private int direction;

    private boolean[] cellAlive;

    public ShipSkeleton(String x_pivot, String y_pivot, int length, int direction) {
        start = new Point(x_pivot, y_pivot);
        this.length = length;
        this.direction = direction;
        cellAlive = new boolean[length];
        for (int i = 0; i < length; i ++) {
            cellAlive[i] = true;
        }
    }

    // TODO: Constructor with 'Point' and direction and length.

    public void hitCell(String coordinates) {
        int distance = calculateDistance(new Point(coordinates));
        cellAlive[distance] = false;
    }

    public boolean isAlive() {
        for (boolean b : cellAlive) {
            if (b) return true;
        }
        return false;
    }

    private int calculateDistance(Point coordinates) {
        return (start.calculateDistance(coordinates));
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < length; i ++) {
            st.append("cell ").append(i + 1).append(" ").append(cellAlive[i] ? "alive" : "dead").append("\n");
        }

        return st.toString();
    }
}