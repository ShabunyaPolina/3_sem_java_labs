package by.bsu.shabunya.lab9.program;

import by.bsu.shabunya.lab9.comparator.ToyComparatorByPrice;
import by.bsu.shabunya.lab9.iterator.ToyIteratorOverAgeLimit;
import by.bsu.shabunya.lab9.toy.Toy;
import by.bsu.shabunya.lab9.toy.ToyList;
import by.bsu.shabunya.lab9.workwithfiles.Reader;

import java.util.ArrayList;
import java.util.Iterator;

public class Program {
    public static void main(String[] args) {

        Reader reader = new Reader();
        ToyList toys = reader.read("data.txt");
        System.out.println(toys);

        toys.sortByPrice();
        System.out.println(toys);

        System.out.println(toys.getToysLimitedByAge(0,5));

//        toys.sort(new ToyComparatorByPrice());
//        System.out.println(toys);
//
//        ArrayList<Toy> specialToys = new ArrayList<>();
//        Iterator<Toy> iter = new ToyIteratorOverAgeLimit(toys, 0,5);
//        while(iter.hasNext()) {
//            specialToys.add(iter.next());
//        }
//        System.out.println(specialToys);
    }
}
