package by.bsu.shabunya.lab9.comparator;

import by.bsu.shabunya.lab9.toy.Toy;

public class ToyComparatorByPrice extends ToyComparator {

    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getPrice() - toy2.getPrice();
    }
}
