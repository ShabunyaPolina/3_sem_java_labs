package by.bsu.shabunya.lab9.program;

import by.bsu.shabunya.lab9.toy.ToyList;
import by.bsu.shabunya.lab9.window.AppFrame;
import by.bsu.shabunya.lab9.workwithfile.Reader;

public class Program {
    public static void main(String[] args) {

        // read data from file
        Reader reader = new Reader();
        String fileName = "data.txt";
        ToyList toys = reader.read(fileName);
        System.out.println("Toys (initial list):\n" + toys);

        // sort list by price
        toys.sortByPrice();
        System.out.println("Toys sorted by price:\n" + toys);

        // Toys from the age range
        int lowerBound = 0;
        int upperBound = 10;
        ToyList ageLimitedToys = toys.getToysLimitedByAge(lowerBound, upperBound);
        System.out.println("Age limited toys (" + lowerBound +
                ", " + upperBound + ")\n" + ageLimitedToys);

        // window
        new AppFrame();
    }
}
