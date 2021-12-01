package by.bsu.shabunya.lab9.iterator;

import by.bsu.shabunya.lab9.toy.Toy;

import java.util.ArrayList;

public class ToyIteratorOverAgeLimit extends ToyIterator {

    private int lowerAgeBound;
    private int upperAgeBound;

    public ToyIteratorOverAgeLimit(ArrayList<Toy> list,
                                   int lowerBound, int upperBound) {
        super(list);
        this.lowerAgeBound = lowerBound;
        this.upperAgeBound = upperBound;
    }

    @Override
    public boolean hasNext() {
        return current != toys.size() - 1 &&
                toys.get(current + 1).getAgeLimit().getLowerBound() >= lowerAgeBound &&
                toys.get(current + 1).getAgeLimit().getUpperBound() <= upperAgeBound;
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

    public int getLowerAgeBound() {
        return lowerAgeBound;
    }

    public void setLowerAgeBound(int lowerAgeBound) {
        this.lowerAgeBound = lowerAgeBound;
    }

    public int getUpperAgeBound() {
        return upperAgeBound;
    }

    public void setUpperAgeBound(int upperAgeBound) {
        this.upperAgeBound = upperAgeBound;
    }
}
