
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
}