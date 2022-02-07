import java.util.HashMap;

public class GameTable {

    private HashMap<String, PointStatus> redGameMap;
    private HashMap<String, PointStatus> blueGameMap;

    // Constants
    private String[] AVAILABLE_X_pivot = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] AVAILABLE_Y_pivot = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

    public GameTable() {
        redGameMap = new HashMap<>();
        blueGameMap = new HashMap<>();

        for (String x_pivot : AVAILABLE_X_pivot) {
            for (String y_pivot : AVAILABLE_Y_pivot) {
                PointStatus p = new PointStatus(x_pivot, y_pivot);
                redGameMap.put(p.getCombination(), p);
                blueGameMap.put(p.getCombination(), p);
            }
        }
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
}
