package by.bsu.shabunya.lab9.iterator;

import by.bsu.shabunya.lab9.toy.Toy;

import java.util.ArrayList;

public class ToyIteratorOverAgeLimit extends ToyIterator {

    private int lowerBound;
    private int upperBound;

    public ToyIteratorOverAgeLimit(ArrayList<Toy> arr,
                                   int lowerBound, int upperBound) {
        super(arr);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean hasNext() {
        return current != toys.size() - 1 &&
                toys.get(current + 1).getAgeLimit().getLowerBound() >= lowerBound &&
                toys.get(current + 1).getAgeLimit().getUpperBound() <= upperBound;
    }

    @Override
    public Toy next() {
        if(hasNext()) {
            ++current;
            return toys.get(current);
        }
        else
            throw new ArrayIndexOutOfBoundsException();
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
}
