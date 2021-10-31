package by.bsu.shabunya.lab5.series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Series {
    private int numberOfElements;
    private final double firstElement;

    public Series(double firstElement) {
        this.firstElement = firstElement;
    }

    public double getFirstElement() {
        return firstElement;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public abstract double calculateElement(int j);

    public double calculateSum(){
        double sum = firstElement;
        for(int i = 2; i <= numberOfElements; ++i) {
            sum += calculateElement(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numberOfElements; ++i) {
            sb.append(String.format("%.2f", calculateElement(i))).append("  ");
        }
        return sb.toString();
    }

    public void saveToFile(String fileName, String comment) {
        try(PrintWriter pw = new PrintWriter(new File(fileName))) {
            pw.print(comment + '\n');
            for(int i = 1; i <= numberOfElements; ++i) {
                pw.print(String.format("%.2f", calculateElement(i)) + "   ");
            }
            pw.print("\nSum: " + calculateSum());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

