
public class userTest {
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
