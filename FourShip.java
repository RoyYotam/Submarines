public class FourShip extends ShipSkeleton {
    private String src;

    public FourShip(String x_pivot, String y_pivot, int direction, String color) {
        super(x_pivot, y_pivot, 4, direction);
        src = "Four" + color + ".png";
    }

    public FourShip(Point p, int direction, String color) {
        super(p, 4, direction);
        src = "Four" + color + ".png";
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Ship status: ").append(this.isAlive() ? "alive" : "dead").append("\n");
        st.append(super.toString());
        return st.toString();
    }

    public static void main(String[] args) {
        FourShip f = new FourShip("a", "1", 1, "Blue");
        f.hitCell("b1");
        System.out.println(f);

        f.hitCell("a1");
        f.hitCell("c1");
        f.hitCell("d1");

        System.out.println(f);
    }
}
