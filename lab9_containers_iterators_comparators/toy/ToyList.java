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
        Iterator<Toy> iterator = new ToyIteratorOverAgeLimit(this, lowerBound, upperBound);
        while (iterator.hasNext()) {
            toys.add(iterator.next());
        }
        return toys;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Toy toy : this) {
            stringBuilder.append(toy).append(";\n");
        }
        return stringBuilder.toString();
    }
}
