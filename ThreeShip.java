
public class ThreeShip extends ShipSkeleton {
    private String src;

    public ThreeShip(String x_pivot, String y_pivot, int direction, String color) {
        super(x_pivot, y_pivot, 3, direction);
        src = "Three" + color + ".png";
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Ship status: ").append(this.isAlive() ? "alive" : "dead").append("\n");
        st.append(super.toString());
        return st.toString();
    }
}
