
public class Fleet {
    private ShipSkeleton[] ships = new ShipSkeleton[5];
    private String color;

    public Fleet(String[][] coordinates, String color) {
        this.color = color;

        ships[0] = new FourShip(coordinates[0][0], coordinates[0][1], 1, color);
        ships[1] = new ThreeShip(coordinates[1][0], coordinates[1][1], 1, color);
        ships[2] = new ThreeShip(coordinates[2][0], coordinates[2][1], 1, color);
        ships[3] = new TwoShip(coordinates[3][0], coordinates[3][1], 1, color);
        ships[4] = new TwoShip(coordinates[4][0], coordinates[4][1], 1, color);
    }
}
