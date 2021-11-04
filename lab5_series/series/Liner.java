package by.bsu.shabunya.lab5.series;

public class Liner extends Series{

    public Liner(){};

    public Liner(double firstElement, double difference) {
        super(firstElement, difference);
    }

    public Liner(double firstElement, double difference, int numberOfElements) {
        super(firstElement, difference, numberOfElements);
    }

    @Override
    public double calculateElement(int j) {
        return getFirstElement() + getFactor() * (j - 1);
    }
}
