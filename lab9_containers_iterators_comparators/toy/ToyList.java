package by.bsu.shabunya.lab9.toy;

import by.bsu.shabunya.lab9.comparator.ToyComparatorByPrice;
import by.bsu.shabunya.lab9.iterator.ToyIteratorOverAgeLimit;

import java.util.ArrayList;
import java.util.Iterator;

public class ToyList extends ArrayList<Toy> {

    public void sortByPrice() {
        sort(new ToyComparatorByPrice());
    }

    public ToyList getToysLimitedByAge(int lowerBound, int upperBound) {
        ToyList toys = new ToyList();
        Iterator<Toy> iter = new ToyIteratorOverAgeLimit(this, 0, 5);
        while (iter.hasNext()) {
            toys.add(iter.next());
        }
        return toys;
    }
}
