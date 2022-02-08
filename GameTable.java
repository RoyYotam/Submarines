import java.util.HashMap;

public class GameTable {
    /*
        Class used by the SERVER for running the game.
     */

    private HashMap<String, PointStatus> redGameMap;
    private HashMap<String, PointStatus> blueGameMap;
    private HashMap<String, HashMap> match = new HashMap<>();

    // Constants
    private String[] AVAILABLE_Y_pivot = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] AVAILABLE_X_pivot = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

    public GameTable() {
        redGameMap = new HashMap<>();
        match.put("red", redGameMap);
        blueGameMap = new HashMap<>();
        match.put("blue", blueGameMap);

        for (String x_pivot : AVAILABLE_X_pivot) {
            for (String y_pivot : AVAILABLE_Y_pivot) {
                PointStatus p = new PointStatus(x_pivot, y_pivot);
                redGameMap.put(p.getCombination(), p);
                blueGameMap.put(p.getCombination(), p);
            }
        }
    }

    public PointStatus checkCell(String combination, String color) {
        return (PointStatus) match.get(color).get(combination);
    }

    public boolean isCellFreeAround(String combination, String color) {
        boolean result = false;
        String comUp = "", comDown = "", comRight = "", comLeft = "";
        if (combination.charAt(0) > 97) comUp += Character.toString(combination.charAt(0) - 1) +
                combination.charAt(1);
        if (combination.charAt(0) < 106) comDown += Character.toString(combination.charAt(0) + 1) +
                combination.charAt(1);
        if (combination.charAt(1) > 49) comRight += "" + combination.charAt(0)  +
                Character.toString(combination.charAt(1) - 1);
        if (combination.length() == 2) comLeft += "" + combination.charAt(0)
                + (combination.charAt(1) == '9' ? "10" : Character.toString(combination.charAt(1) + 1));

        if (!comUp.equals("")) result = result ||
                (((PointStatus) match.get(color).get(comUp)).isTaken()
                        && ! ((PointStatus) match.get(color).get(comUp)).isBeenGuessed());
        if (!comDown.equals("")) result = result ||
                (((PointStatus) match.get(color).get(comDown)).isTaken()
                        && ! ((PointStatus) match.get(color).get(comDown)).isBeenGuessed());
        if (!comRight.equals("")) result = result ||
                (((PointStatus) match.get(color).get(comRight)).isTaken()
                        && ! ((PointStatus) match.get(color).get(comRight)).isBeenGuessed());
        if (!comLeft.equals("")) result = result ||
                (((PointStatus) match.get(color).get(comLeft)).isTaken()
                        && ! ((PointStatus) match.get(color).get(comLeft)).isBeenGuessed());

        return result;
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Red game map:" + "\n");
        int count = 0;
        for (PointStatus p : redGameMap.values()) {
            st.append(p.toString() + "\t");
            if (count % 5 == 0) {
                st.append("\n");
            }
            count ++;
        }

        st.append("\n" + "Blue game map:" + "\n");
        count = 0;
        for (PointStatus p : blueGameMap.values()) {
            st.append(p.toString() + "\t");
            if (count % 5 == 0) {
                st.append("\n");
            }
            count ++;
        }

        return st.toString();
    }

    public void setBoardCoordinate(String color, String coordinate) {
        ((PointStatus) match.get(color).get(coordinate)).setTaken();
    }
}
