package by.bsu.shabunya.lab5.series;

public abstract class Series {
    private int elementsNumber;

    public abstract double calculateElement(int j);

    public double calculateSum(){
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

    public void saveToFile() {}
}

