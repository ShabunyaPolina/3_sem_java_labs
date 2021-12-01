package by.bsu.shabunya.lab9.comparator;

import by.bsu.shabunya.lab9.toy.Toy;

import java.util.Comparator;

public abstract class ToyComparator implements Comparator<Toy> {

    @Override
    public abstract int compare(Toy toy1, Toy toy2);
}
