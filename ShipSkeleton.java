
public class ShipSkeleton {
    private Point start;
    private int length;
    private int direction;

    public ShipSkeleton(String x_pivot, String y_pivot, int length, int direction) {
        start = new Point(x_pivot, y_pivot);
        this.length = length;
        this.direction = direction;
    }

}