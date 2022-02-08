
public class Fleet {
    private int FLEET_SIZE = 5;
    private ShipSkeleton[] ships = new ShipSkeleton[FLEET_SIZE];
    private String color;

    public Fleet(String[][] coordinates, String color) {
        this.color = color;

        ships[0] = new FourShip(coordinates[0][0], coordinates[0][1], 1, color);
        ships[1] = new ThreeShip(coordinates[1][0], coordinates[1][1], 1, color);
        ships[2] = new ThreeShip(coordinates[2][0], coordinates[2][1], 1, color);
        ships[3] = new TwoShip(coordinates[3][0], coordinates[3][1], 1, color);
        ships[4] = new TwoShip(coordinates[4][0], coordinates[4][1], 1, color);
    }

    public Fleet(Point[] coordinates, String color) {
        this.color = color;

        ships[0] = new FourShip(coordinates[0], 1, color);
        ships[1] = new ThreeShip(coordinates[1], 1, color);
        ships[2] = new ThreeShip(coordinates[2], 1, color);
        ships[3] = new TwoShip(coordinates[3], 1, color);
        ships[4] = new TwoShip(coordinates[4], 1, color);
    }

    public boolean fleetEliminated() {
        for (ShipSkeleton s : ships) {
            if (s.isAlive()) return false;
        }
        return true;
    }

    public String[] getCoordinates() {
        String[] coordinates = new String[14];
        int current = 0;
        for (int i = 0; i < FLEET_SIZE; i ++) {
            for (String s : ships[i].getCoordinates()) {
                coordinates[current] = s;
                current++;
            }
        }

        return coordinates;
    }
}
