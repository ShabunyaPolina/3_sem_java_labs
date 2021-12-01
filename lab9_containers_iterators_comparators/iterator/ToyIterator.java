package by.bsu.shabunya.lab9.iterator;

import by.bsu.shabunya.lab9.toy.Toy;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ToyIterator implements Iterator<Toy> {

    protected ArrayList<Toy> toys;
    protected int current;

    public ToyIterator(ArrayList<Toy> toys) {
        this.toys = toys;
        current = -1;
    }

    @Override
    public abstract boolean hasNext();

    @Override
    public abstract Toy next();

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public int getCurrent() {
        return current;
    }
}
