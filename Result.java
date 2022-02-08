
public class Result {
    private boolean missed = false;
    private boolean hit = false;
    private boolean almost = false;
    private boolean outOfBound = false;

    public Result(int n) {
        if (n == 1) missed = true;
        else if (n == 2) hit = true;
        else if (n == 3) almost = true;
        else if (n == 4) outOfBound = true;
    }

    public boolean isAlmost() {
        return almost;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isMissed() {
        return missed;
    }

    public boolean isOutOfBound() {
        return outOfBound;
    }
}
