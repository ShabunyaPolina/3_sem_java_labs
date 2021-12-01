package by.bsu.shabunya.lab9.workwithfile;

import by.bsu.shabunya.lab9.exception.ReaderException;
import by.bsu.shabunya.lab9.toy.Toy;
import by.bsu.shabunya.lab9.toy.ToyList;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    public ToyList read(String fileName) {
        ToyList toys = new ToyList();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            String[] line;
            while (scanner.hasNextLine()){
                line = scanner.nextLine().split("\\W");
                if(line.length != 4)
                    throw new ReaderException("Invalid data");
                toys.add(new Toy(line[0], Integer.parseInt(line[1]),
                        Integer.parseInt(line[2]), Integer.parseInt(line[3])));
            }
        } catch (IOException | NumberFormatException | ReaderException e) {
            e.printStackTrace();
        }
        return toys;
    }
}
