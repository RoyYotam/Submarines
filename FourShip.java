public class FourShip extends ShipSkeleton {
    private String src;

    public FourShip(String x_pivot, String y_pivot, int direction, String color) {
        super(x_pivot, y_pivot, 4, direction);
        src = "Four" + color + ".png";
    }
}
