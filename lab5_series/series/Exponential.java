package by.bsu.shabunya.lab5.series;

public class Exponential extends Series{
    private double ratio;

    public Exponential(double firstElement, double ratio) {
        super(firstElement);
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public double calculateElement(int j) {
        return getFirstElement() * Math.pow(ratio, j - 1);
    }
}
