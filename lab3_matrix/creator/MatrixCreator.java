package lab.creator;

import lab.entity.Matrix;
import lab.exception.MatrixException;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class MatrixCreator {

    public void createFromFile(Matrix matrix, File f) throws Exception {
        try (Scanner scanner = new Scanner(new FileReader(f))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] elements = scanner.nextLine().split("\\s");
                if (elements.length != matrix.getHorizontalSize() ||
                        i >= matrix.getVerticalSize())
                    throw new MatrixException("Invalid matrix size");
                for (int j = 0; j < elements.length; ++j) {
                    matrix.setElement(i, j, Double.parseDouble(elements[j]));
                }
                ++i;
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void fillRandomized(Matrix matrix, int minValue, int maxValue) throws MatrixException {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
                matrix.setElement(i, j, value);
            }
        }
    }
}

