

public class TwoShip extends ShipSkeleton {
    private String src;

    public TwoShip(String x_pivot, String y_pivot, int direction, String color) {
        super(x_pivot, y_pivot, 2, direction);
        src = "Two" + color + ".png";
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Ship status: ").append(this.isAlive() ? "alive" : "dead").append("\n");
        st.append(super.toString());
        return st.toString();
    }
}

