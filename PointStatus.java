
public class PointStatus extends Point {

    private boolean isTaken;
    private boolean beenGuessed;

    public PointStatus(String X_pivot, String Y_pivot) {
        super(X_pivot, Y_pivot);
        setDefault();
    }

    private void setDefault() {
        isTaken = false;
        beenGuessed = false;
    }

    public boolean isBeenGuessed() {
        return beenGuessed;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setBeenGuessed() {
        this.beenGuessed = true;
    }

    public void setTaken() {
        isTaken = true;
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append(super.toString());
        st.append(" t = " + isTaken + ", g = " + beenGuessed);
        return st.toString();
    }
}
