
public class Point {
    private String X_pivot;
    private String Y_pivot;

    public Point(String x_pivot, String y_pivot) {
        this.X_pivot = x_pivot;
        this.Y_pivot = y_pivot;
    }

    public Point(String coordinates) {
        this.X_pivot = "" + coordinates.charAt(0);
        this.Y_pivot = "" + coordinates.charAt(1);
    }

    public String toString() {
        return "( " + X_pivot + ", " + Y_pivot + " )";
    }

    public String getX_pivot() {
        return X_pivot;
    }

    public String getY_pivot() {
        return Y_pivot;
    }

    public String getCombination() {
        return getX_pivot() + getY_pivot();
    }

    public int calculateDistance(Point coordinates) {
        return ((coordinates.getX_pivot().charAt(0) - X_pivot.charAt(0)) + (coordinates.getY_pivot().charAt(0) - Y_pivot.charAt(0)));
    }
}
