package by.bsu.shabunya.lab5.series;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class Series {
    private double firstElement;
    private double factor;
    private int numberOfElements;

    public Series(){};

    public Series(double firstElement, double factor) {
        this.firstElement = firstElement;
        this.factor = factor;
    }

    public Series(double firstElement, double factor, int numberOfElements) {
        this.firstElement = firstElement;
        this.factor = factor;
        this.numberOfElements = numberOfElements;
    }

    public double getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(double firstElement) {
        this.firstElement = firstElement;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public abstract double calculateElement(int j);

    public double calculateSum() {
        double sum = firstElement;
        for (int i = 2; i <= numberOfElements; ++i) {
            sum += calculateElement(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numberOfElements; ++i) {
            sb.append(String.format("%.2f", calculateElement(i))).append("  ");
        }
        return sb.toString();
    }

    public void saveToFile(String fileName, String comment) throws IOException {
        PrintWriter pw = new PrintWriter(fileName);
        pw.print(comment + '\n');
        for (int i = 1; i <= numberOfElements; ++i) {
            pw.print(String.format("%.2f", calculateElement(i)) + "   ");
        }
        pw.print("\nSum: " + calculateSum());
    }
}

