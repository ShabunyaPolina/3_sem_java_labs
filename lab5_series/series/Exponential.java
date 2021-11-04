package by.bsu.shabunya.lab5.series;

public class Exponential extends Series{

    public Exponential(){};

    public Exponential(double firstElement, double ratio) {
        super(firstElement, ratio);
    }

    public Exponential(double firstElement, double ratio, int numberOfElements) {
        super(firstElement, ratio, numberOfElements);
    }

    @Override
    public double calculateElement(int j) {
        return getFirstElement() * Math.pow(getFactor(), j - 1);
    }
}
