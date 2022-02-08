
public class GameEngine {

    private GameTable gameTable;

    public GameEngine() {
        gameTable = new GameTable();
    }

    public void fillBoard(String color, String[] coordinates) {
        for (String coordinate : coordinates) {
            gameTable.setBoardCoordinate(color, coordinate);
        }
    }

    public Result makeMove(String combination, String color) {
        if (! goodCombination(combination)) return  new Result(4); // Out of table

        PointStatus p = gameTable.checkCell(combination, color);
        if (p.isBeenGuessed()) return new Result(4); // Already guessed
        else  {
            p.setBeenGuessed();

            if (p.isTaken()) return new Result(2); // Hit!
            else if (gameTable.isCellFreeAround(combination, color)) return new Result(3); // Almost
            else return new Result(1); // Missed
        }
    }

    public boolean goodCombination(String combination) {
        boolean letter = (combination.charAt(0) > 96 && combination.charAt(0) < 107);
        boolean number = (combination.charAt(1) > 48 && combination.charAt(1) < 57);
        if (combination.length() > 2) {
            if (combination.charAt(1) == '1' && combination.charAt(2) == '0') return letter;
            else return false;
        }
        return number && letter;
    }

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.fillBoard("blue", new Fleet(new Point[]{
                new Point("a", "1"),
                new Point("b", "1"),
                new Point("c", "1"),
                new Point("d", "1"),
                new Point("e", "1")}, "blue").getCoordinates());

        System.out.println(gameEngine.makeMove("c3", "blue").isHit());

        System.out.println(gameEngine.makeMove("c3", "blue").isMissed());
        System.out.println(gameEngine.makeMove("c3", "blue").isOutOfBound());
    }
}
