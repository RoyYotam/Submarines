
public class ThreeShip extends ShipSkeleton {
    private String src;

    public ThreeShip(String x_pivot, String y_pivot, int direction, String color) {
        super(x_pivot, y_pivot, 3, direction);
        src = "Three" + color + ".png";
    }
}
