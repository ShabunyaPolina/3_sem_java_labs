package by.bsu.shabunya.lab9.toy;

public class AgeLimit {

    private int lowerBound;
    private int upperBound;

    public AgeLimit(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        return "(" + lowerBound +
                ", " + upperBound +
                ')';
    }
}
