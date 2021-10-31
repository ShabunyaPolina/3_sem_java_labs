package by.bsu.shabunya.lab5.program;

import by.bsu.shabunya.lab5.series.*;

public class Program {

    public static void main(String[] args) {
        // arithmetic progression
        Liner l = new Liner(1.1, 3.2);
        System.out.println("Arithmetic progression: \nFirst element:   " +
                l.getFirstElement() + "\nDifference:   " + l.getDifference());

        int j = 3;
        System.out.println("Element № " + j + " :   " + l.calculateElement(j));

        l.setNumberOfElements(10);
        System.out.println(l.getNumberOfElements() + " first elements:   " + l);

        System.out.println("Sum of first " + l.getNumberOfElements() +
                " elements:   " + l.calculateSum());

        System.out.println();

        // geometric progression
        Exponential e = new Exponential(2, 10);
        System.out.println("Geometric progression: \nFirst element:   " +
                e.getFirstElement() + "\nRatio:   " + e.getRatio());

        System.out.println("Element № " + j + " :   " + e.calculateElement(j));

        e.setNumberOfElements(10);
        System.out.println(e.getNumberOfElements() + " first elements:   " + e);

        System.out.println("Sum of first " + e.getNumberOfElements() +
                " elements:   " + e.calculateSum());

        // Save to file
        l.saveToFile("liner.txt", "Arithmetic progression");
        e.saveToFile("Exponential.txt", "Geometric progression");
    }
}
