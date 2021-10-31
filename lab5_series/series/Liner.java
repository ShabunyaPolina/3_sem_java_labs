package by.bsu.shabunya.lab5.series;

public class Liner extends Series{
    private double difference;

    public Liner(double firstElement, double difference) {
        super(firstElement);
        this.difference = difference;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    @Override
    public double calculateElement(int j) {
        return getFirstElement() + difference * (j - 1);
    }
}
